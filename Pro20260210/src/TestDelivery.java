
public class TestDelivery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hellow world!");
		
		// 별도의 메소드를 호출해서 결과값을 int로 받음
        int result = runCalculation(); 
        
        // 결과 확인
        System.out.println("결과값: " + result);
	}
	
	
	public static int runCalculation() {
		int n = 21, w = 3, num = 15;
		
		//restriction 
		// 2 <= n <= 100
		// 1 <= w <=10
		// 1 <= num <= 100
		int answer = 0;
        
        // 1. 꺼내려는 상자(num)의 위치(층, 열) 구하기
        int targetLayer = (num - 1) / w;
        int targetPos = getColumn(num, w);
        
        // 2. 전체 상자 중 가장 높은 층 구하기
        int maxLayer = (n - 1) / w;
        
        // 3. targetLayer부터 위로 올라가며 같은 열에 상자가 있는지 확인
        for (int h = targetLayer; h <= maxLayer; h++) {
            // 해당 층(h)의 같은 열(targetPos)에 위치하는 상자의 번호를 역산
            int currentBoxNum = getBoxNumber(h, targetPos, w);
            
            // 상자 번호가 전체 개수 n보다 작거나 같으면 꺼내야 할 상자에 포함
            if (currentBoxNum <= n) {
                answer++;
            }
        }
        
        return answer;

	}
	
	// 층(h)과 열(pos) 정보를 바탕으로 상자 번호를 돌려주는 함수
    private static int getBoxNumber(int h, int pos, int w) {
        if (h % 2 == 0) { // 짝수 층: 왼쪽 -> 오른쪽
            return h * w + pos + 1;
        } else { // 홀수 층: 오른쪽 -> 왼쪽
            return h * w + (w - 1 - pos) + 1;
        }
    }
    
    // 특정 상자 번호의 열(0 ~ w-1) 위치를 구해주는 함수
    private static int getColumn(int num, int w) {
        int h = (num - 1) / w;
        int remain = (num - 1) % w;
        if (h % 2 == 0) {
            return remain;
        } else {
            return (w - 1) - remain;
        }
    }

}
