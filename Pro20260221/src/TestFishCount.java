import java.util.ArrayList;
import java.util.List;

public class TestFishCount {

    // 물고기 데이터를 담을 클래스 (파일 하단 혹은 외부에 작성)
    static class Fish {
        int id;
        Integer length;

        Fish(int id, Integer length) {
            this.id = id;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        // 1. 데이터 준비 (문제의 예시 데이터)
        List<Fish> fishInfo = new ArrayList<>();
        fishInfo.add(new Fish(0, 13));
        fishInfo.add(new Fish(1, 50));
        fishInfo.add(new Fish(2, 40));
        fishInfo.add(new Fish(3, 43));
        fishInfo.add(new Fish(4, null)); // 10cm 이하
        fishInfo.add(new Fish(5, null)); // 10cm 이하

        // 2. Stream API를 사용해 10cm 이하(null)인 물고기 수 계산
        long fishCount = fishInfo.stream()
                                 .filter(f -> f.length == null)
                                 .count();

        // 3. 결과 출력
        System.out.println("FISH_COUNT");
        System.out.println(fishCount);
    }
}