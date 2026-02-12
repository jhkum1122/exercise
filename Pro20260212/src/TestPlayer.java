
public class TestPlayer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 테스트 케이스 설정 (문제의 예시 1번)
        String video_len = "34:33";
        String pos = "13:00";
        String op_start = "00:55";
        String op_end = "02:55";
        String[] commands = {"next", "prev"};

        // 결과 출력
        String result = solution(video_len, pos, op_start, op_end, commands);
        System.out.println("최종 위치: " + result); // 예상 결과: "13:00"
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 모든 시간을 초 단위로 변환
        int videoLenSec = timeToSec(video_len);
        int posSec = timeToSec(pos);
        int opStartSec = timeToSec(op_start);
        int opEndSec = timeToSec(op_end);

        // [1] 시작 직후 오프닝 구간 체크
        posSec = skipOpening(posSec, opStartSec, opEndSec);

        // [2] 명령어 수행
        for (String command : commands) {
            if (command.equals("prev")) {
                posSec = Math.max(0, posSec - 10);
            } else if (command.equals("next")) {
                posSec = Math.min(videoLenSec, posSec + 10);
            }
            
            // 각 명령어 수행 후 오프닝 체크
            posSec = skipOpening(posSec, opStartSec, opEndSec);
        }

        // [3] 최종 결과를 "mm:ss" 형식으로 변환
        return secToTime(posSec);
    }

    // "mm:ss" -> 초(int) 변환
    private static int timeToSec(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    // 초(int) -> "mm:ss" 변환
    private static String secToTime(int totalSec) {
        int m = totalSec / 60;
        int s = totalSec % 60;
        return String.format("%02d:%02d", m, s);
    }

    // 오프닝 구간 건너뛰기
    private static int skipOpening(int current, int start, int end) {
        if (current >= start && current <= end) {
            return end;
        }
        return current;
    }
}