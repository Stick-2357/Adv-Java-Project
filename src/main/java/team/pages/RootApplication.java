package team.pages;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import team.Profile;
import team.requests.GetRosterRequest;
import team.requests.NewChildRequest;
import team.requests.UpdateChildRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class RootApplication extends Application {
    static ArrayList<Profile> roster = new ArrayList<>();
    static ObjectInputStream inputFromServer;
    static ObjectOutputStream outputToServer;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        try {
            // TODO: Continue to reattempt a connection
            Socket socket = new Socket("localhost", 8000);
            inputFromServer = new ObjectInputStream(socket.getInputStream());
            outputToServer = new ObjectOutputStream(socket.getOutputStream());

            // TODO: Go to HomePage when connected
            Button create = new Button("Create Roster");
            Button edit = new Button("Edit Roster");
            Button trip = new Button("Create Trip");

            HBox pane = new HBox(create, edit, trip);
            pane.setAlignment(Pos.CENTER);

            NewChildPageHandler roster = new NewChildPageHandler();
            create.setOnAction(roster);

            RosterPageHandler editor = new RosterPageHandler();
            edit.setOnAction(editor);

            TripPageHandler tripMaker = new TripPageHandler();
            trip.setOnAction(tripMaker);

            Scene scene = new Scene(pane);
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void refreshRoster() throws IOException, ClassNotFoundException {
        outputToServer.writeObject(new GetRosterRequest());
        roster = (ArrayList<Profile>) inputFromServer.readObject();
    }

    public static void addChild(Profile profile) throws IOException, ClassNotFoundException {
        outputToServer.writeObject(new NewChildRequest(profile));
        roster = (ArrayList<Profile>) inputFromServer.readObject();
    }

    public static void updateChild(Profile profile) throws IOException, ClassNotFoundException {
        outputToServer.writeObject(new UpdateChildRequest(profile));
        roster = (ArrayList<Profile>) inputFromServer.readObject();
    }
}
