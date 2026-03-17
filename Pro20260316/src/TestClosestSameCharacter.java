import java.util.*;

public class TestClosestSameCharacter {
    /**
     * 가장 가까운 같은 글자를 찾는 메서드
     * @param s 입력 문자열
     * @return 각 위치에서의 결과 배열
     */
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        // 각 문자의 가장 최근 위치를 저장할 Map
        // Key: 알파벳(Character), Value: 마지막 인덱스(Integer)
        Map<Character, Integer> charMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            // 1. 이전에 나온 적이 없는 경우
            if (!charMap.containsKey(current)) {
                answer[i] = -1;
            } 
            // 2. 이전에 나온 적이 있는 경우
            else {
                // 현재 인덱스(i) - 마지막 위치
                answer[i] = i - charMap.get(current);
            }
            
            // 현재 문자의 위치를 Map에 업데이트 (다음 비교를 위해)
            charMap.put(current, i);
        }
        
        return answer;
    }

    // Eclipse에서 실행 및 테스트를 위한 main 메서드
    public static void main(String[] args) {
        TestClosestSameCharacter csc = new TestClosestSameCharacter();
        
        // 예제 1: "banana"
        String s1 = "banana";
        System.out.println("Input: " + s1);
        System.out.println("Result: " + Arrays.toString(csc.solution(s1)));
        
        System.out.println("---");
        
        // 예제 2: "foobar"
        String s2 = "foobar";
        System.out.println("Input: " + s2);
        System.out.println("Result: " + Arrays.toString(csc.solution(s2)));
    }
}