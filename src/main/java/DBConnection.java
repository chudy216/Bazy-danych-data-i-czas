import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DBConnection {
        private static String dbhost = "jdbc:mysql://localhost:3306/figury";
        private static String username = "test1";
        private static String password = "12345";
        private static Connection conn;

        public static Connection createNewDBConnection() {
            try  {
                conn = DriverManager.getConnection(
                        dbhost, username, password);
                System.out.println("Połączono. Wszystko OK.");
            } catch (SQLException e) {
                System.out.println("Nie można utworzyć połączenia z bazą danych!");
                e.printStackTrace();
            } finally {
                return conn;
            }
        }
    }
