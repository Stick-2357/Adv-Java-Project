import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    Connection connection;

    public Database(String user, String pass) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        System.out.println("Connecting to a selected database...");
        // Open a connection
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/profiles", user, pass);) {
            System.out.println("Connected database successfully...");
        } catch (SQLException e) {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", user, pass);
                 Statement stmt = conn.createStatement();
            ) {
                String sql = "CREATE DATABASE profiles";
                stmt.executeUpdate(sql);
                System.out.println("Database created successfully...");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public Statement getStatement() throws SQLException {
        Statement statement = this.connection.createStatement();
        return statement;
    }
}
