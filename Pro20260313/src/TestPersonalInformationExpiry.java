import java.util.*;

public class TestPersonalInformationExpiry {

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        
        // 1. 오늘 날짜를 '일(day)' 단위로 환산
        int todayTotalDays = getTotalDays(today);
        
        // 2. 약관 종류와 유효기간을 Map에 저장 (찾기 쉽게)
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            termMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }
        
        // 3. 각 개인정보의 만료 여부 확인
        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");
            String dateStr = splitPrivacy[0];
            String termType = splitPrivacy[1];
            
            // 수집된 날짜를 '일' 단위로 환산
            int collectTotalDays = getTotalDays(dateStr);
            
            // 만료일 계산: 수집일 + (유효달 수 * 28)
            // 주의: 만료일 당일부터 파기해야 하므로 계산된 날짜를 오늘과 비교
            int expiryTotalDays = collectTotalDays + (termMap.get(termType) * 28);
            
            // 오늘 날짜가 만료일과 같거나 크면 파기 대상
            if (todayTotalDays >= expiryTotalDays) {
                answerList.add(i + 1); // 번호는 1번부터 시작
            }
        }
        
        // List를 배열로 변환하여 반환
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    // 날짜 문자열(YYYY.MM.DD)을 총 '일(days)'로 변환하는 헬퍼 메서드
    private int getTotalDays(String date) {
        String[] splitDate = date.split("\\.");
        int year = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int day = Integer.parseInt(splitDate[2]);
        
        // 1년 = 12달 * 28일 = 336일
        // 1달 = 28일
        return (year * 12 * 28) + (month * 28) + day;
    }

    // 이클립스에서 테스트를 위한 main 메서드
    public static void main(String[] args) {
        TestPersonalInformationExpiry sol = new TestPersonalInformationExpiry();
        
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        
        int[] result = sol.solution(today, terms, privacies);
        System.out.println(Arrays.toString(result)); // [1, 3] 출력
    }
}