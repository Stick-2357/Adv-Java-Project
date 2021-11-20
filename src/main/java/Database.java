import java.sql.*;

public class Database {
    Connection connection;

    public Database(String user, String pass) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        this.connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", user, pass);
        System.out.println("Database connected");
    }

    public Statement getStatement() throws SQLException {
        Statement statement = this.connection.createStatement();
        return statement;
    }
}
