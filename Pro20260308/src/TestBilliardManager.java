import java.util.*;

public class TestBilliardManager {

    public static void main(String[] args) {
        int m = 10, n = 10, startX = 3, startY = 7;
        int[][] balls = {{7, 7}, {2, 7}, {7, 3}};

        int[] result = solution(m, n, startX, startY, balls);

        // 결과 출력 (정석 일반 for문 형식)
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        // 1. 모든 공에 대해 최단 거리를 계산합니다.
        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            int minDist = Integer.MAX_VALUE;

            // 2. 4가지 방향(상, 하, 좌, 우)으로 쿠션을 칠 때를 모두 고려
            // 상(0, n), 하(0, 0), 좌(0, 0), 우(m, 0) 방향 대칭 이동
            
            // 예: 위쪽 벽을 맞출 때
            if (!(startX == targetX && startY < targetY)) { // 직선상에 공이 있으면 안 됨
                int d = (int)(Math.pow(startX - targetX, 2) + Math.pow(startY + targetY - 2 * n, 2));
                if (d < minDist) minDist = d;
            }
            // 아래, 좌, 우 방향도 같은 방식으로 계산하여 minDist 갱신
            // (위 코드는 대칭 이동 원리를 보여주기 위한 예시입니다)
            
            answer[i] = minDist;
        }
        return answer;
    }
}