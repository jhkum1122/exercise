import java.util.ArrayList;
import java.util.List;

public class TestFishInfo {

    public static void main(String[] args) {
        // 1. 데이터 준비
        List<Double> lengths = new ArrayList<>();
        lengths.add(13.37);
        lengths.add(50.00);
        lengths.add(40.00);
        lengths.add(43.33);
        lengths.add(null); // 10cm 이하 데이터 (NULL)
        lengths.add(32.00);

        // 2. 최대값을 저장할 변수 초기화
        double maxVal = 0.0;

        // 3. 일반적인 for문 (인덱스 사용 방식)
        for (int i = 0; i < lengths.size(); i++) {
            Double currentLength = lengths.get(i);
            
            // 데이터가 NULL이 아니고, 현재 최대값보다 큰 경우에만 업데이트
            if (currentLength != null && currentLength > maxVal) {
                maxVal = currentLength;
            }
        }

        // 4. 결과 출력 (MAX_LENGTH 컬럼명 준수)
        System.out.println("MAX_LENGTH");
        System.out.printf("%.2fcm\n", maxVal);
    }
}