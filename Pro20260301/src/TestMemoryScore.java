import java.util.*;

public class TestMemoryScore { // 클래스 이름 변경

    public static void main(String[] args) {
        // 예시 데이터
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
            {"may", "kein", "kain", "radi"},
            {"may", "kein", "brin", "deny"},
            {"kon", "kain", "may", "coni"}
        };

        int[] result = solution(name, yearning, photo);

        // 결과 출력 (정석 for문 형식)
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 1. 이름별 그리움 점수를 저장할 Map 생성
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }

        // 2. 사진별 점수를 담을 결과 배열
        int[] answer = new int[photo.length];

        // 3. 중첩 for문으로 사진 속 인물 점수 합산
        for (int i = 0; i < photo.length; i++) {
            int totalScore = 0;
            for (int j = 0; j < photo[i].length; j++) {
                String person = photo[i][j];
                
                // Map에 이름이 있다면 점수 추가
                if (scoreMap.containsKey(person)) {
                    totalScore += scoreMap.get(person);
                }
            }
            answer[i] = totalScore;
        }

        return answer;
    }
}