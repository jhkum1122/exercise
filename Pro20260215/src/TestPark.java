import java.util.Arrays;

public class TestPark {

    public static void main(String[] args) {
        // 입출력 예시 데이터
        int[] mats = {5, 3, 2};
        String[][] park = {
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "-1", "-1"},
            {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}
        };

        System.out.println("공원 돗자리 배치 검사 시작!");
        
        int result = solution(mats, park);
        
        System.out.println("지민이가 깔 수 있는 가장 큰 돗자리 크기: " + result);
    }

    public static int solution(int[] mats, String[][] park) {
        // 1. 돗자리 크기를 큰 순서대로 정렬 (가장 큰 것부터 확인하기 위함)
        Arrays.sort(mats);
        
        // 2. 가장 큰 돗자리부터 깔 수 있는지 확인
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            
            // 공원의 모든 좌표를 돌며 돗자리를 놓을 시작점(r, c)을 찾음
            for (int r = 0; r <= park.length - size; r++) {
                for (int c = 0; c <= park[0].length - size; c++) {
                    
                    // 해당 위치에 size 크기만큼 깔 수 있는지 확인
                    if (canPlace(park, r, c, size)) {
                        return size; // 깔 수 있다면 바로 그 크기 반환
                    }
                }
            }
        }
        
        return -1; // 아무것도 깔 수 없는 경우
    }

    // 특정 위치(r, c)에서 size 크기의 돗자리를 깔 수 있는지 체크하는 메소드
    private static boolean canPlace(String[][] park, int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                // "-1"이 아니면 이미 사람이 있는 것이므로 깔 수 없음
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}