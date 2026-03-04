import java.util.*;

public class TestDesktopManager {

    public static void main(String[] args) {
        // 예시 데이터 1번
        String[] wallpaper = {".#...", "..#..", "...#."};

        int[] result = solution(wallpaper);

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

    public static int[] solution(String[] wallpaper) {
        // 1. 최소/최대 좌표를 찾기 위한 초기값 설정
        // 시작점(min)은 아주 큰 값으로, 끝점(max)은 아주 작은 값으로 시작합니다.
        int minRow = 51, minCol = 51; 
        int maxRow = 0, maxCol = 0;

        int rowLen = wallpaper.length;
        int colLen = wallpaper[0].length();

        // 2. 바탕화면 전체를 행(i)과 열(j)로 순회합니다.
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                
                // 3. 파일('#')이 있는 위치를 발견하면 좌표 갱신
                if (wallpaper[i].charAt(j) == '#') {
                    // 가장 위쪽 행과 왼쪽 열 찾기
                    if (i < minRow) minRow = i;
                    if (j < minCol) minCol = j;
                    
                    // 가장 아래쪽 행과 오른쪽 열 찾기 (파일의 끝점은 좌표 + 1)
                    if (i + 1 > maxRow) maxRow = i + 1;
                    if (j + 1 > maxCol) maxCol = j + 1;
                }
            }
        }

        // 4. [lux, luy, rdx, rdy] 순서로 결과 반환
        int[] answer = {minRow, minCol, maxRow, maxCol};
        return answer;
    }
}