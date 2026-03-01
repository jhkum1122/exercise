import java.util.*;

public class MostGifts {
    public static void main(String[] args) {
        // 테스트 케이스 1 예시 데이터
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        int result = solution(friends, gifts);
        System.out.println("다음 달에 가장 많이 받는 선물 개수: " + result);
    }

    public static int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        
        // 1. 친구 이름별 인덱스 매핑 (이름으로 배열 위치를 찾기 위함)
        Map<String, Integer> friendMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            friendMap.put(friends[i], i);
        }

        // 2. 누가 누구에게 줬는지 기록하는 2차원 배열 (giftMatrix[준사람][받은사람])
        int[][] giftMatrix = new int[n][n];
        // 3. 선물 지수 계산을 위한 배열 (준 선물 - 받은 선물)
        int[] giftScore = new int[n];

//        for (String gift : gifts) {
//            String[] split = gift.split(" ");

        for (int i = 0; i < gifts.length; i++) {
        	
            String[] split = gifts[i].split(" ");
            int giverIdx = friendMap.get(split[0]);
            int receiverIdx = friendMap.get(split[1]);

            giftMatrix[giverIdx][receiverIdx]++;
            giftScore[giverIdx]++; // 준 사람은 지수 +1
            giftScore[receiverIdx]--; // 받은 사람은 지수 -1
        }

        // 4. 다음 달에 받을 선물 계산
        int[] nextMonthGifts = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // i와 j가 서로 주고받은 기록 확인
                int iToJ = giftMatrix[i][j];
                int jToI = giftMatrix[j][i];

                if (iToJ > jToI) {
                    // i가 더 많이 줬으면 i가 하나 받음
                    nextMonthGifts[i]++;
                } else if (iToJ < jToI) {
                    // j가 더 많이 줬으면 j가 하나 받음
                    nextMonthGifts[j]++;
                } else {
                    // 주고받은 기록이 없거나 같으면 '선물 지수' 비교
                    if (giftScore[i] > giftScore[j]) {
                        nextMonthGifts[i]++;
                    } else if (giftScore[i] < giftScore[j]) {
                        nextMonthGifts[j]++;
                    }
                    // 선물 지수까지 같으면 아무도 받지 않음 (처리 불필요)
                }
            }
        }

        // 5. 가장 큰 값 찾기
        int maxGifts = 0;
        for (int count : nextMonthGifts) {
            maxGifts = Math.max(maxGifts, count);
        }

        return maxGifts;
    }
}