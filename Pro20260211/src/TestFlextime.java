
public class TestFlextime {

	public static void main(String[] args) {
		// 예시 데이터 (입출력 예 #1 기준)
        int[] schedules = {700, 800, 1100};
        int[][] timelogs = {
            {710, 2359, 1050, 700, 650, 631, 659},
            {800, 801, 805, 800, 759, 810, 809},
            {1105, 1001, 1002, 600, 1059, 1001, 1100}
        };
        int startday = 5; // 금요일 시작

        System.out.println("출근 이벤트 검사 시작!");

        // 결과 확인
        int result = runTimeflex(schedules, timelogs, startday);
        
        System.out.println("결과값 (상품 받을 직원 수): " + result);
    }

    // 유연근무제 로직 메소드
    public static int runTimeflex(int[] schedules, int[][] timelogs, int startday) {
        int prizeWinner = 0;

        for (int i = 0; i < schedules.length; i++) {
            // 1. 출근 인정 시각 계산 (희망 시각 + 10분)
            int limitTime = schedules[i] + 10;
            
            // 분(MM)이 60분을 넘어가면 시간(HH) 올림 처리
            if (limitTime % 100 >= 60) {
                limitTime = limitTime + 100 - 60;
            }

            boolean isSuccess = true;

            // 2. 일주일(7일)간의 출근 기록 확인
            for (int j = 0; j < 7; j++) {
                // 현재 요일 계산 (1:월, 2:화, 3:수, 4:목, 5:금, 6:토, 7:일)
                int dayOfWeek = (startday + j - 1) % 7 + 1;

                // 주말(토요일 6, 일요일 7)이면 체크 생략
                if (dayOfWeek >= 6) {
                    continue;
                }

                // 3. 지각 여부 판단
                if (timelogs[i][j] > limitTime) {
                    isSuccess = false; // 한 번이라도 늦으면 탈락
                    break;
                }
            }

            if (isSuccess) {
                prizeWinner++;
            }
        }
        return prizeWinner;
    }
}