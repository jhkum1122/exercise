import java.util.*;

public class TestStringSplitter {
    /**
     * 규칙에 따라 문자열을 분해하고 그 개수를 반환하는 메서드
     * @param s 입력 문자열
     * @return 분해된 문자열의 개수
     */
    public int solution(String s) {
        int answer = 0;
        
        char x = s.charAt(0); // 첫 글자를 기준 x로 설정
        int sameCount = 0;    // x와 같은 글자 수
        int diffCount = 0;    // x와 다른 글자 수

        for (int i = 0; i < s.length(); i++) {
            // 카운트가 둘 다 0이면 새로운 덩어리의 시작임
            if (sameCount == 0 && diffCount == 0) {
                x = s.charAt(i);
            }

            if (s.charAt(i) == x) {
                sameCount++;
            } else {
                diffCount++;
            }

            // 두 횟수가 같아지면 분리
            if (sameCount == diffCount) {
                answer++;
                sameCount = 0; // 초기화
                diffCount = 0;
            }
        }

        // 반복문이 끝났는데 아직 분리되지 않은 글자가 남아있는 경우
        if (sameCount > 0 || diffCount > 0) {
            answer++;
        }

        return answer;
    }

    // Eclipse에서 테스트를 위한 main 메서드
    public static void main(String[] args) {
        TestStringSplitter splitter = new TestStringSplitter();

        // 예제 1: "banana" -> "ba", "na", "na" (3개)
        System.out.println("Result 1: " + splitter.solution("banana"));

        // 예제 2: "abracadabra" -> 6개
        System.out.println("Result 2: " + splitter.solution("abracadabra"));

        // 예제 3: "aaabbaccccabba" -> 3개
        System.out.println("Result 3: " + splitter.solution("aaabbaccccabba"));
    }
}