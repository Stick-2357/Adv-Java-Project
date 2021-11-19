import java.sql.SQLException;
import java.sql.*;

public class Session {
    Database database;

    public Session() throws SQLException, ClassNotFoundException{
        database = new Database("alex", "tiger");
    }

    public void addProfile(Profile profile) {
        try {
            Statement statement = database.getStatement();
        }
        catch (SQLException ex){
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Session session = new Session();
        Profile alex = new Profile("alex", "111-222-3344", "totallylegit@gmail.com", "123 Oak Street");
        session.addProfile(alex);
    }
}
