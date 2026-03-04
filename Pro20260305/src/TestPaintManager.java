import java.util.*;

public class TestPaintManager {

    public static void main(String[] args) {
        // 예시 데이터 1번
        int n = 8; // 전체 구역 수
        int m = 4; // 롤러의 길이
        int[] section = {2, 3, 6}; // 칠해야 할 구역들

        int result = solution(n, m, section);

        // 결과 출력 (정호 님이 요청하신 일반 형식)
        System.out.println(result);
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0; // 롤러를 사용한 총 횟수
        int paintedUntil = 0; // 현재까지 페인트가 칠해진 마지막 구역 번호

        // 1. 칠해야 하는 구역 리스트를 하나씩 확인합니다.
        for (int i = 0; i < section.length; i++) {
            int currentTarget = section[i];

            // 2. 현재 구역이 이미 칠해진 범위(paintedUntil) 밖에 있다면?
            if (currentTarget > paintedUntil) {
                // 3. 롤러를 한 번 사용하고, 롤러가 닿는 끝 지점을 새로 계산합니다.
                answer++;
                
                // 현재 위치(currentTarget)부터 롤러 길이(m)만큼 칠해짐
                // 예: 2번 구역에서 길이 4인 롤러를 쓰면 2, 3, 4, 5번까지 칠해짐 (2 + 4 - 1 = 5)
                paintedUntil = currentTarget + m - 1;
            }
        }

        // 4. 최종 롤러질 횟수 반환
        return answer;
    }
}