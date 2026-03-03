import java.util.*;

public class TestParkWalker {

    public static void main(String[] args) {
        // 예시 데이터 1번
        String[] park = {"SOO", "OOO", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};

        int[] result = solution(park, routes);

        // 결과 출력 (정호 님이 요청하신 일반 for문 형식)
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            
            // 마지막 원소가 아니면 쉼표(,)와 공백을 추가합니다.
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        
        int r = 0; // 현재 행(세로) 위치
        int c = 0; // 현재 열(가로) 위치

        // 1. 시작 지점('S')의 좌표를 찾습니다.
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                }
            }
        }

        // 2. 이동 명령을 하나씩 수행합니다.
        for (int i = 0; i < routes.length; i++) {
            String[] move = routes[i].split(" ");
            String dir = move[0]; // 방향
            int dist = Integer.parseInt(move[1]); // 거리

            int tempR = r;
            int tempC = c;
            boolean canMove = true;

            // 3. 거리만큼 한 칸씩 이동하며 검사합니다.
            for (int j = 0; j < dist; j++) {
                if (dir.equals("N")) tempR--;
                else if (dir.equals("S")) tempR++;
                else if (dir.equals("W")) tempC--;
                else if (dir.equals("E")) tempC++;

                // 공원 범위를 벗어나거나 장애물('X')을 만나는지 체크
                if (tempR < 0 || tempR >= h || tempC < 0 || tempC >= w || park[tempR].charAt(tempC) == 'X') {
                    canMove = false;
                    break;
                }
            }

            // 4. 모든 칸 이동이 가능했을 때만 실제 위치를 업데이트합니다.
            if (canMove) {
                r = tempR;
                c = tempC;
            }
        }

        return new int[]{r, c};
    }
}