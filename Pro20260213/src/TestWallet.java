public class TestWallet {

    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] wallet1 = {30, 15};
        int[] bill1 = {26, 17};
        System.out.println("결과 1: " + solution(wallet1, bill1)); // 예상: 1

        // 테스트 케이스 2
        int[] wallet2 = {50, 50};
        int[] bill2 = {100, 241};
        System.out.println("결과 2: " + solution(wallet2, bill2)); // 예상: 4
    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        // 지폐를 지갑에 넣을 수 있을 때까지 반복
        // (지폐의 작은 쪽 > 지갑의 작은 쪽) OR (지폐의 큰 쪽 > 지갑의 큰 쪽) 인 동안 반복
        while (!canFit(wallet, bill)) {
            // 가로, 세로 중 긴 쪽을 반으로 접음
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }

        return answer;
    }

    // 지갑에 들어가는지 확인하는 도우미 메서드
    private static boolean canFit(int[] wallet, int[] bill) {
        int walletMin = Math.min(wallet[0], wallet[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);
        int billMin = Math.min(bill[0], bill[1]);
        int billMax = Math.max(bill[0], bill[1]);

        // 지폐의 작은 쪽이 지갑의 작은 쪽보다 작거나 같고, 
        // 동시에 지폐의 큰 쪽이 지갑의 큰 쪽보다 작거나 같아야 함
        return (billMin <= walletMin && billMax <= walletMax);
    }
}