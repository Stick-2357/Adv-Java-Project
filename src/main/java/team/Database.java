package team;

import java.sql.*;

/**
* Semester Project
 * Description: Main database class that instantiates database driver and connects to MySQL session
 */

public class Database {
    Connection conn;

    //Constructor instantiates JDBC driver and tries to connect to database
    public Database(String user, String pass) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        System.out.println("Connecting to a selected database...");

        //Try to connect to database
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/route_manager", user, pass);
            System.out.println("Connected database successfully...");
            Statement stmt = conn.createStatement();

            //If table doesn't exist, create it, otherwise move on
            if (tableExistsSQL(conn, "profiles")) {
                System.out.println("Table exists, moving on...");
            } else {
                System.out.println("Table doesn't exist, creating...");
                stmt.executeUpdate("CREATE TABLE PROFILES " +
                        "(id INTEGER not NULL AUTO_INCREMENT, " +
                        " name VARCHAR(255)," +
                        " emergency_num VARCHAR(255)," +
                        " email VARCHAR(255)," +
                        " address VARCHAR(255)," +
                        "PRIMARY KEY ( id ))");
                System.out.println("Table created successfully...");
            }
        //If database does not exist, create it and the corresponding table
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", user, pass);
                Statement stmt = conn.createStatement();
                String sql = "CREATE DATABASE route_manager";
                stmt.executeUpdate(sql);
                System.out.println("Database created successfully...");

                stmt.executeUpdate("CREATE TABLE PROFILES " +
                        "(id INTEGER not NULL AUTO_INCREMENT, " +
                        " name VARCHAR(255)," +
                        " emergency_num VARCHAR(255)," +
                        " email VARCHAR(255)," +
                        " address VARCHAR(255)," +
                        "PRIMARY KEY ( id ))");
                System.out.println("Table created successfully...");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    //Returns an SQL statement object to be handled by parent method
    public Statement getStatement() throws SQLException {
        Statement statement = this.conn.createStatement();
        return statement;
    }

    //Helper function to check for existing table in database
    static boolean tableExistsSQL(Connection connection, String tableName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) "
                + "FROM information_schema.tables "
                + "WHERE table_name = ?"
                + "LIMIT 1;");
        preparedStatement.setString(1, tableName);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1) != 0;
    }
}
