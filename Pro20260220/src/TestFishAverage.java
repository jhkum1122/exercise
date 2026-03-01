import java.util.ArrayList;
import java.util.List;

public class TestFishAverage {
    
    // 물고기 정보를 담을 클래스
    static class Fish {
        Integer id;
        Double length; // NULL일 수 있으므로 객체 타입 Double 사용

        Fish(Integer id, Double length) {
            this.id = id;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        // 1. 데이터 준비 (예시 이미지 데이터 입력)
        List<Fish> fishList = new ArrayList<>();
        fishList.add(new Fish(0, 30.0));
        fishList.add(new Fish(1, 50.0));
        fishList.add(new Fish(2, 40.0));
        fishList.add(new Fish(3, 20.0));
        fishList.add(new Fish(4, null)); // NULL 데이터
        fishList.add(new Fish(5, null)); // NULL 데이터

        // 2. 평균 계산 로직
        double sum = 0;
//        for (Fish fish : fishList) {
        for (int i = 0; i < fishList.size(); i++) {
        	// i번째 물고기 객체를 가져옵니다.
        	Fish fish = fishList.get(i);
        	
        	// NULL 체크 로직: NULL이면 10, 아니면 원래 길이
        	double actualLength;
            if (fish.length == null) {
                actualLength = 10.0;
            } else {
                actualLength = fish.length;
            }
            
            sum += actualLength;
        }

        double average = sum / fishList.size();

        // 3. 소수점 3째 자리에서 반올림 (결과: 26.67)
        // String.format을 사용하면 반올림과 출력을 동시에 처리하기 편리합니다.
        String result = String.format("%.2f", average);

        System.out.println("AVERAGE_LENGTH");
        System.out.println(result);
    }
}