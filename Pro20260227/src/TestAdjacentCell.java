import java.util.*;

public class TestAdjacentCell {

    public static void main(String[] args) {
        // 예시 데이터: [코드 번호, 제조일, 최대 수량, 현재 수량]
        int[][] data = {
            {1, 20300104, 100, 80},
            {2, 20300804, 847, 37},
            {3, 20300401, 10, 8}
        };
        String ext = "date";        // 뽑아낼 기준
        int val_ext = 20300501;     // 기준값 (이것보다 작은 데이터만)
        String sort_by = "remain";  // 정렬 기준

        int[][] result = solution(data, ext, val_ext, sort_by);

        // 결과 출력
        /*
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
        */
        
        for (int i = 0; i < result.length; i++) {
            System.out.print("[");
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
                
                // 마지막 원소가 아니면 쉼표(,)를 붙여줍니다.
                if (j < result[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 1. 각 컬럼 명칭에 맞는 인덱스 번호 매핑
        Map<String, Integer> colMap = new HashMap<>();
        colMap.put("code", 0);
        colMap.put("date", 1);
        colMap.put("maximum", 2);
        colMap.put("remain", 3);

        int extIdx = colMap.get(ext);
        int sortIdx = colMap.get(sort_by);

        // 2. 조건(val_ext보다 작은 데이터)에 맞는 데이터만 필터링
        List<int[]> filteredList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            // data[i][extIdx]가 기준값(val_ext)보다 작은지 확인합니다.
            if (data[i][extIdx] < val_ext) {
                // 조건에 맞으면 리스트에 해당 행(data[i])을 추가합니다.
                filteredList.add(data[i]);
            }
        }

        // 3. 지정된 기준(sort_by)으로 오름차순 정렬
        Collections.sort(filteredList, (a, b) -> a[sortIdx] - b[sortIdx]);

        // 4. List를 다시 2차원 배열로 변환하여 반환
        int[][] answer = new int[filteredList.size()][4];
        for (int i = 0; i < filteredList.size(); i++) {
            // List에서 i번째 배열을 꺼내어 answer 배열의 i번째 행에 넣습니다.
            int[] temp = filteredList.get(i); 
            
            for (int j = 0; j < temp.length; j++) {
                answer[i][j] = temp[j];
            }
        }

        return answer;
    }
}