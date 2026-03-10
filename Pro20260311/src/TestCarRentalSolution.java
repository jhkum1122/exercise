import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestCarRentalSolution {

    public static void main(String[] args) {
        // DB 연결 정보 (본인의 환경에 맞게 수정 필요)
    	String url = "jdbc:mysql://localhost:3306/programmers?useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "1234";

        // 실행할 SQL 쿼리
        String sql = "SELECT HISTORY_ID, CAR_ID, " +
                     "DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE, " +
                     "DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE, " +
                     "CASE WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '장기 대여' " +
                     "ELSE '단기 대여' END AS RENT_TYPE " +
                     "FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY " +
                     "WHERE START_DATE LIKE '2022-09%' " +
                     "ORDER BY HISTORY_ID DESC";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("HISTORY_ID | CAR_ID | START_DATE | END_DATE | RENT_TYPE");
            System.out.println("----------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("HISTORY_ID");
                int carId = rs.getInt("CAR_ID");
                String start = rs.getString("START_DATE");
                String end = rs.getString("END_DATE");
                String type = rs.getString("RENT_TYPE");

                System.out.printf("%d | %d | %s | %s | %s\n", id, carId, start, end, type);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}