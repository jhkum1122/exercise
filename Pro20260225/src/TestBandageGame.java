public class TestBandageGame {

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 테스트 케이스 1 예시
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};

        int result = sol.solution(bandage, health, attacks);
        System.out.println("최종 남은 체력: " + result);
    }
}

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int currentHealth = health;
        int lastAttackTime = 0;
        
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량

        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];

            // 1. 공격 사이의 시간 동안 회복
            int timeDiff = attackTime - lastAttackTime - 1;

            if (timeDiff > 0) {
                // 초당 회복량 적용
                currentHealth += timeDiff * x;
                // 연속 성공 보너스 적용
                currentHealth += (timeDiff / t) * y;
                
                // 최대 체력 초과 방지
                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
            }

            // 2. 몬스터 공격
            currentHealth -= damage;
            
            // 3. 체력이 0 이하가 되면 -1 반환
            if (currentHealth <= 0) {
                return -1;
            }

            lastAttackTime = attackTime;
        }

        return currentHealth;
    }
}