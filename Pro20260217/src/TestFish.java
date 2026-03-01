import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestFish {

    // 물고기 정보를 담을 내부 정적 클래스
    static class Fish {
        int id;
        Double length;

        Fish(int id, Double length) {
            this.id = id;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        // 1. 문제 예시에 나온 데이터 입력
        List<Fish> list = new ArrayList<>();
        list.add(new Fish(0, 30.0));
        list.add(new Fish(1, 50.0));
        list.add(new Fish(2, 40.0));
        list.add(new Fish(3, 20.0));
        list.add(new Fish(4, null));  // 10cm 이하는 NULL
        list.add(new Fish(5, 13.0));
        list.add(new Fish(6, 60.0));
        list.add(new Fish(7, 55.0));
        list.add(new Fish(8, 73.0));
        list.add(new Fish(9, 73.0));
        list.add(new Fish(10, 22.0));
        list.add(new Fish(11, 17.0));

        // 2. 문제 조건에 따른 정렬
        // - 1순위: 길이(LENGTH) 기준 내림차순
        // - 2순위: ID 기준 오름차순
        Collections.sort(list, new Comparator<Fish>() {
            @Override
            public int compare(Fish f1, Fish f2) {
                // NULL(10cm 이하) 처리: 정렬 시 가장 뒤로 보냄
                if (f1.length == null) return 1;
                if (f2.length == null) return -1;

                if (!f1.length.equals(f2.length)) {
                    return f2.length.compareTo(f1.length); // 길이 내림차순
                }
                return Integer.compare(f1.id, f2.id); // ID 오름차순
            }
        });

        // 3. 결과 출력 (ID와 LENGTH만, 최대 10마리)
        System.out.println("ID\tLENGTH");
        int count = 0;
        for (Fish f : list) {
            // 가장 큰 물고기 10마리 중 10cm 이하(NULL)는 없다는 조건 반영
            if (f.length != null && count < 10) {
                System.out.println(f.id + "\t" + f.length.intValue());
                count++;
            }
        }
    }
}