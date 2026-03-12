import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCalculateAverageDailyFee {

    // DB 접속 정보 (사용하시는 환경에 맞춰 수정하세요)
    private static final String URL = "jdbc:mysql://localhost:3306/programmers?useUnicode=true&characterEncoding=UTF-8"; 
    private static final String USER = "kumjh";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // 실행할 SQL 쿼리
        // AVG로 평균을 구하고 ROUND(..., 0)으로 소수점 첫째 자리에서 반올림합니다.
        String sql = "SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE " +
                     "FROM CAR_RENTAL_COMPANY_CAR " +
                     "WHERE CAR_TYPE = 'SUV'";

        try {
            // 1. 드라이버 로딩 및 연결
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Statement 생성
            pstmt = conn.prepareStatement(sql);

            // 3. 쿼리 실행 및 결과 조회
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // 컬럼명 'AVERAGE_FEE'로 결과값 가져오기
                int averageFee = rs.getInt("AVERAGE_FEE");
                
                // 결과 출력
                System.out.println("AVERAGE_FEE");
                System.out.println(averageFee);
            }

        } catch (SQLException e) {
            System.err.println("DB 연결 또는 쿼리 실행 중 오류 발생");
            e.printStackTrace();
        } finally {
            // 4. 자원 해제 (연결 역순)
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}