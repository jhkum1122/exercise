public class TestEcoli {

    public static void main(String[] args) {
        // 예시 데이터: 각 대장균의 GENOTYPE (10진수)
        int[] genotypes = {8, 15, 1, 13}; // ID 1, 2, 3, 4 순서
        
        int result = solution(genotypes);
        System.out.println("조건에 맞는 대장균 개체 수: " + result); // 예상 결과: 2
    }

    public static int solution(int[] genotypes) {
        int count = 0;

        for (int i = 0; i < genotypes.length; i++) {
            int genotype = genotypes[i];

            // 1. 2번 형질 보유 여부 체크 (2진수 두 번째 자리가 1인지 확인)
            boolean hasNoTrait2 = false;
            if ((genotype & 2) == 0) {
                // 2번 형질이 없으면 true
                hasNoTrait2 = true;
            }

            // 2. 1번 또는 3번 형질 보유 여부 체크
            boolean hasTrait1Or3 = false;
            if ((genotype & 1) != 0) {
                // 1번 형질이 있는 경우
                hasTrait1Or3 = true;
            } else if ((genotype & 4) != 0) {
                // 1번은 없지만 3번 형질이 있는 경우
                hasTrait1Or3 = true;
            }

            // 3. 최종 조건 판별: 2번 형질이 없으면서 + (1번 또는 3번)이 있는 경우
            if (hasNoTrait2 == true && hasTrait1Or3 == true) {
                count++;
            }
        }

        return count;
    }
}