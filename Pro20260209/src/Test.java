
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 테스트할 문자열 입력
        String X = "992413";
        String Y = "432993";
        
        int[] elementX = null;//
        int[] elementY = null;

        
        // 2. 숫자인지 먼저 체크
        if (isNumeric(X)) {
            System.out.println("'" + X + "'는 숫자입니다. 분석을 시작합니다.");
            
            // 3. 숫자 개수 세기 실행
            elementX = countDigits(X);
            
            // 4. 결과 출력
            for (int i = 0; i < elementX.length; i++) {
                if (elementX[i] > 0) { // 등장한 숫자만 출력
                    System.out.println("숫자 " + i + ": " + elementX[i] + "개");
                }
            }

            System.out.println("'" + Y + "'는 숫자입니다. 분석을 시작합니다.");

            // 3. 숫자 개수 세기 실행
            elementY = countDigits(Y);
            
            // 4. 결과 출력
            for (int i = 0; i < elementY.length; i++) {
                if (elementY[i] > 0) { // 등장한 숫자만 출력
                    System.out.println("숫자 " + i + ": " + elementY[i] + "개");
                }
            }

            
            System.out.println("여기서 부터 같은 숫자 찾기 시작");
            // 5. 공통 숫자 찾기 및 결과 생성
            StringBuilder answer = new StringBuilder();

            // 9부터 0까지 거꾸로 확인 (큰 수를 만들기 위함)
            for (int i = 9; i >= 0; i--) {
                // 두 배열 중 더 적게 나타난 횟수가 공통 분모
                int commonCount = Math.min(elementX[i], elementY[i]);
                
//                System.out.println("i : " + i + ", commonConnt : " + commonCount);
                // 공통된 개수만큼 숫자를 반복해서 추가
                for (int j = 0; j < commonCount; j++) {
                    answer.append(i);
                }
            }

            // 6. 결과 처리
            String resultStr = answer.toString();

            if (resultStr.isEmpty()) {
                System.out.println("공통된 숫자가 없습니다.");
            } else if (resultStr.startsWith("0")) {
                // 모든 숫자가 0인 경우 (예: "000" -> "0")
                System.out.println("가장 큰 수: 0");
            } else {
                System.out.println("공통 숫자로 만든 가장 큰 수: " + resultStr);
            }
            
        } else {
            System.out.println("'" + X + "'에 숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }

    // 숫자인지 체크하는 메소드
    public static boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }

    // 각 자리 숫자의 개수를 세는 메소드
    public static int[] countDigits(String number) {
        int[] counts = new int[10];
        
//        
//        for (char c : number.toCharArray()) {
//            counts[c - '0']++;
//        }
//        
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i); // 배열의 i번째 요소를 꺼냄
            // 가져온 문자 c를 숫자로 변환하여 해당 인덱스의 카운트를 증가시킵니다.
            counts[c - '0']++; // 해당 숫자의 인덱스 값을 1 증가
        }
        return counts;
    }

}
