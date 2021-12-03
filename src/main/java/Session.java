import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Session {
    Database database;

    public Session() throws SQLException, ClassNotFoundException, IOException {
        Properties props = PropertiesUtil.getProperties();
        database = new Database(props.getProperty("mysqluser"), props.getProperty("mysqlpass"));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Session session = new Session();
        System.out.println(session.getAllProfiles());
    }

    // TODO: Add a getAllProfiles Method
    public ArrayList<Profile> getAllProfiles() {
        ArrayList<Profile> profiles = new ArrayList<Profile>();
        try {
            Statement stmt = database.getStatement();
            String sql = "SELECT * FROM PROFILES";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Profile p = new Profile(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("emergency_num"),
                        rs.getString("email"),
                        rs.getString("address"));
                profiles.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return profiles;
    }

    public void addProfile(Profile profile) {
        try {
            Statement stmt = database.getStatement();
            String sql = "INSERT INTO PROFILES (name, emergency_num, email, address) " +
                    "VALUES ('"+ profile.name + "', '" + profile.emergencyNum + "', '" + profile.email + "', '" + profile.address + "')";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editProfile(Profile profile) {
        try {
            Statement stmt = database.getStatement();
            String sql = "UPDATE PROFILES " +
                    "SET name = '" + profile.name +
                    "', emergency_num = '" + profile.emergencyNum +
                    "', email = '" + profile.email +
                    "', address = '" + profile.address +
                    "' WHERE id = " + profile.id;
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteProfile(Profile profile) {
        try {
            Statement stmt = database.getStatement();
            String sql = "DELETE FROM PROFILES " +
                    "WHERE id = " + profile.id;
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

//    public void editRoute() {
//
//    }
//
//    public String generateAttendance() {
//        return "";
//    }
}
