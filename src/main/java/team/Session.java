package team;

import team.requests.AbstractRequest;
import team.requests.NewChildRequest;
import team.requests.UpdateChildRequest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
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

        new Thread(() -> {
            try {
                // create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                System.out.println("Server started...");

                while (true) {
                    // Listen for a new connection request
                    Socket socket = serverSocket.accept();
                    System.out.println("New connection started");
                    new Thread(new HandleAClient(socket)).start();
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }).start();

    }

    class HandleAClient implements Runnable {
        private Socket socket; // a connected socket

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
                outputToClient.flush();
                ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());

                while (true) {
                    AbstractRequest request = (AbstractRequest) inputFromClient.readObject();
                    System.out.println(request);
                    switch (request.getRequestName()) {
                        case "Get Roster": {
                            System.out.println("Got roster request");
                            outputToClient.writeObject(getAllProfiles());
                            System.out.println("sent roster");
                            break;
                        }
                        case "New Child": {
                            NewChildRequest newChildRequest = (NewChildRequest) request;
                            addProfile(newChildRequest.getProfile());
                            break;
                        }
                        case "Update Child": {
                            UpdateChildRequest updateChildRequest = (UpdateChildRequest) request;
                            editProfile(updateChildRequest.getProfile());
                            break;
                        }
                        case "Get Route": {

                            break;
                        }
                        default: {
                            System.err.println("Unknown request received: " + request);
                        }
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Session session = new Session();
    }

    // TODO: Add a getAllProfiles Method
    public ArrayList<Profile> getAllProfiles() {
        ArrayList<Profile> profiles = new ArrayList<>();
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
                    "VALUES ('" + profile.name + "', '" + profile.emergencyNum + "', '" + profile.email + "', '" + profile.address + "')";
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
