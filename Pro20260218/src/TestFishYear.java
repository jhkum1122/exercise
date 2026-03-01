import java.util.ArrayList;
import java.util.List;

public class TestFishYear {

    // 물고기 정보를 담을 객체 클래스
    static class Fish {
        int id;
        String time; // "2021/12/04" 형식

        Fish(int id, String time) {
            this.id = id;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        // 1. 문제의 예시 데이터 생성
        List<Fish> fishInfo = new ArrayList<>();
        fishInfo.add(new Fish(0, "2021/12/04"));
        fishInfo.add(new Fish(1, "2020/03/07"));
        fishInfo.add(new Fish(2, "2020/03/07"));
        fishInfo.add(new Fish(3, "2022/03/09"));
        fishInfo.add(new Fish(4, "2022/04/08"));
        fishInfo.add(new Fish(5, "2021/04/28"));

        int fishCount = 0;
        // 2. 2021년도에 잡은 물고기 수 구하기 (일반 for문 형태)
        for (int i = 0; i < fishInfo.size(); i++) {
        	// i번째 물고기 객체를 가져옴
            Fish f = fishInfo.get(i);
            // 연도 4자리가 "2021"인지 확인
            if (f.time.substring(0, 4).equals("2021")) {
                fishCount++;
            }
        }

        // 3. 결과 출력 (문제의 출력 형식 반영)
        System.out.println("FISH_COUNT");
        System.out.println("----------");
        System.out.println(fishCount);
    }
}