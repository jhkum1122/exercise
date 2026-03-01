import java.sql.*;

public class PythonDeveloperSearch {
    public static void main(String[] args) {
        // DB 연결 정보 (사용자 환경에 맞게 수정 필요)
        String url = "jdbc:mysql://localhost:3306/programmers";
        String user = "root";
        String password = "1234";

        // SQL 쿼리문: Python 스킬이 1, 2, 3번 컬럼 중 어디든 있는 경우 조회
        String query = "SELECT ID, EMAIL, FIRST_NAME, LAST_NAME " +
                       "FROM DEVELOPER_INFOS " +
                       "WHERE SKILL_1 = 'Python' OR SKILL_2 = 'Python' OR SKILL_3 = 'Python' " +
                       "ORDER BY ID ASC";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("ID\tEMAIL\t\t\tFIRST_NAME\tLAST_NAME");
            System.out.println("------------------------------------------------------------");

            while (rs.next()) {
                String id = rs.getString("ID");
                String email = rs.getString("EMAIL");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");

                System.out.printf("%s\t%s\t%s\t%s\n", id, email, firstName, lastName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}