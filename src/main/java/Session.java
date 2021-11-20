import java.sql.SQLException;
import java.sql.Statement;

/*
Pseudocode
1. On session start, create database if one doesn't exist - Done
2. In each profile function, create statement and corresponding SQL query to update database object
    2a. Possibly make override executeQuery func for db object?
3. Client-Server relations:
    3a. Session interface?
    3b. HelloApplication is client, Session is server
    3c. Start dedicated server session object alongside client session object
    3d. Would need to create dedicated driver file to create objects
    3e. Client communicates user inputs to server, server formulates queries with input, injects into DB
 */

public class Session {
    Database database;

    public Session() throws SQLException, ClassNotFoundException {
        database = new Database("root", "L$839ppj!"); // TODO: Move to config file
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Session session = new Session();
        Profile alex = new Profile("alex", "111-222-3344", "totallylegit@gmail.com", "123 Oak Street");
//        session.addProfile(alex);
    }

    public void addProfile(Profile profile) {
        try {
            Statement statement = database.getStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editProfile() {

    }

    public void deleteProfile() {

    }

    public void editRoute() {

    }

    public String generateAttendance() {
        return "";
    }
}
