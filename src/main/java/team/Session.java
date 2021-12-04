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

/**
 * Semester Project
 * Description: Session driver class to act as server side
 */

public class Session {
    Database database;

    //Constructor that starts the Server socket and instantiates the database object using PropertiesUtil data
    public Session() throws SQLException, ClassNotFoundException, IOException {
        Properties props = PropertiesUtil.getProperties();
        database = new Database(props.getProperty("mysqluser"), props.getProperty("mysqlpass"));

        //Start new thread to start listening for client connections
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

    //Runnable client class to be used and handled by main thread process
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

                //Create new Request object based on user behavior
                while (true) {
                    AbstractRequest request = (AbstractRequest) inputFromClient.readObject();
                    System.out.println(request);
                    switch (request.getRequestName()) {
                        case "Get Roster": {
                            outputToClient.writeObject(getAllProfiles());
                            break;
                        }
                        case "New Child": {
                            NewChildRequest newChildRequest = (NewChildRequest) request;
                            addProfile(newChildRequest.getProfile());
                            break;
                        }
                        case "Update Child": {
                            System.out.println("recieved update request");
                            UpdateChildRequest updateChildRequest = (UpdateChildRequest) request;
                            editProfile(updateChildRequest.getProfile());
                            System.out.println("Finished");
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

    //Main driver function that creates Session object
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Session session = new Session();
    }

    //Creates and executes SQL statement to return a comprehensive list of profiles from the database
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

    //Creates and executes SQL statement to add a profile to the database
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

    //Creates and executes SQL statement to edit an existing profile in the database
    public void editProfile(Profile profile) {
        try {
            Statement stmt = database.getStatement();
            String sql = "UPDATE PROFILES " +
                    "SET name = '" + profile.name +
                    "', emergency_num = '" + profile.emergencyNum +
                    "', email = '" + profile.email +
                    "', address = '" + profile.address +
                    "' WHERE id = " + profile.id;
            System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Creates and executes SQL statement to drop a profile from the database
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
}
