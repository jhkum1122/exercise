
public class TestSmallSubString {
	public int solution(String t, String p) {
        int count = 0;
        int pLength = p.length();
        int tLength = t.length();
        
        // p의 길이가 최대 18자리이므로 Long 타입으로 변환하여 비교
        long pValue = Long.parseLong(p);

        // t에서 p와 같은 길이의 부분 문자열을 추출하여 비교
        for (int i = 0; i <= tLength - pLength; i++) {
            // substring(start, end)는 end 인덱스 직전까지 추출함
            String sub = t.substring(i, i + pLength);
            
            if (Long.parseLong(sub) <= pValue) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TestSmallSubString exam = new TestSmallSubString();
        
        // 테스트 케이스 실행
        System.out.println("result 1: " + exam.solution("3141592", "271"));      // 예상: 2
        System.out.println("result 2: " + exam.solution("500220839878", "7"));  // 예상: 8
        System.out.println("result 3: " + exam.solution("10203", "15"));        // 예상: 3
    }
}