import java.util.*;


public class TestRunRace {
	public static void main(String[] args) {
        // 예시 데이터
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] result = solution(players, callings);

        // 결과 출력 (정호 님이 요청하신 일반 for문 형식)
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print("\"" + result[i] + "\""); // 문자열 강조를 위해 따옴표 추가
            
            // 마지막 원소가 아니면 쉼표(,)와 공백을 붙여줍니다.
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static String[] solution(String[] players, String[] callings) {
        // 1. 선수의 현재 위치를 빛의 속도로 찾기 위한 Map 생성
        Map<String, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        // 2. 호명된 선수를 순서대로 추월 처리
        for (int i = 0; i < callings.length; i++) {
            String calledPlayer = callings[i];
            
            // 현재 불린 선수의 등수 확인
            int currentRank = rankMap.get(calledPlayer);
            
            // 바로 앞 선수의 등수와 이름 확인 (currentRank - 1)
            int frontRank = currentRank - 1;
            String frontPlayer = players[frontRank];

            // 3. 배열 내 위치 교체 (Swap)
            players[frontRank] = calledPlayer;
            players[currentRank] = frontPlayer;

            // 4. Map 데이터 갱신 (등수 정보 업데이트)
            rankMap.put(calledPlayer, frontRank);
            rankMap.put(frontPlayer, currentRank);
        }

        return players;
    }
}