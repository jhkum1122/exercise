import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestCarRentalSearch {
    public static void main(String[] args) {
        // DB 연결 정보 (실제 환경에 맞게 수정 필요)
    	String url = "jdbc:mysql://localhost:3306/programmers?useUnicode=true&characterEncoding=UTF-8";
    	String user = "kumjh";
        String password = "1234";

        // '네비게이션'이 포함된 데이터를 조회하는 SQL
        // LIKE 연산자를 사용하여 OPTIONS 컬럼에 '네비게이션'이 포함된 행을 찾습니다.
        String query = "SELECT * FROM CAR_RENTAL_COMPANY_CAR " +
                       "WHERE OPTIONS LIKE '%네비게이션%' " +
                       "ORDER BY CAR_ID DESC";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("CAR_ID | CAR_TYPE | DAILY_FEE | OPTIONS");
            while (rs.next()) {
            	System.out.println(rs.getInt("CAR_ID") + " | " + 
                        rs.getString("CAR_TYPE") + " | " + 
                        rs.getInt("DAILY_FEE") + " | " + 
                        rs.getString("OPTIONS"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}