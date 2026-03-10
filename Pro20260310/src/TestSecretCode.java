
public class TestSecretCode {
	public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            // index만큼 한 단계씩 이동
            for (int j = 0; j < index; j++) {
                curr++; // 다음 알파벳으로 이동
                
                // 'z'를 넘어가면 'a'로 순환
                if (curr > 'z') {
                    curr = 'a';
                }
                
                // 만약 skip해야 할 문자에 포함되어 있다면, 한 번 더 이동해야 함
                // 이를 위해 루프 인덱스 j를 건드리지 않고, skip에 없을 때까지 반복
                if (skip.contains(String.valueOf(curr))) {
                    j--; 
                }
            }
            answer.append(curr);
        }

        return answer.toString();
    }

    // 이클립스에서 실행 확인을 위한 main 메서드
    public static void main(String[] args) {
        TestSecretCode sol = new TestSecretCode();
        
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        
        String result = sol.solution(s, skip, index);
        
        System.out.println("결과: " + result); // 출력: happy
    }
}