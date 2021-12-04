//This acts as the root menu of the GUI.
//It starts by connecting to the server before offering the menu selections to the User.
//The three selections offered are: "Create Roster", "Edit Roster", and "Create Trip".

package team.pages;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import team.Profile;
import team.jsonobjects.Location;
import team.jsonobjects.Route;
import team.requests.GetRosterRequest;
import team.requests.GetRouteRequest;
import team.requests.NewChildRequest;
import team.requests.UpdateChildRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class RootApplication extends Application {
    static ArrayList<Profile> roster = new ArrayList<>();
    static Socket socket;
    static ObjectInputStream inputFromServer;
    static ObjectOutputStream outputToServer;
    //These create an ArrayList to store profiles, the socket used to connect to the server,
    //and the input/output variables used to communicate with the server.

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        try {
            // TODO: Continue to reattempt a connection
            System.out.println("Attempting to connect to server...");
            socket = new Socket("localhost", 8000);
            System.out.println("Successfully connected");
            outputToServer = new ObjectOutputStream(socket.getOutputStream());
            outputToServer.flush();
            inputFromServer = new ObjectInputStream(socket.getInputStream());
            //This is where the GUI attempts to connect to the server through its created socket.


            Button create = new Button("Create Roster");
            Button edit = new Button("Edit Roster");
            Button trip = new Button("Create Trip");
            //These are the definitions for the main menu buttons.

            // TODO: Come up with a name for the program
            Label welcome = new Label("Welcome to INSERT NAME HERE");
            welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
            Label instructions = new Label("Please begin by clicking \"Create Roster\"");
            instructions.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 12));
            //These create a welcome, and simple instructions for the User.

            HBox top = new HBox(welcome);
            top.setAlignment(Pos.CENTER);
            HBox middle = new HBox(create, edit, trip);
            middle.setAlignment(Pos.CENTER);
            HBox bottom = new HBox(instructions);
            bottom.setAlignment(Pos.CENTER);
            VBox rootVBox = new VBox(top, middle, bottom);
            rootVBox.setAlignment(Pos.CENTER);
            rootVBox.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
            //This creates the pane that displays the main menu.

            NewChildPageHandler roster = new NewChildPageHandler();
            create.setOnAction(roster);

            RosterPageHandler editor = new RosterPageHandler();
            edit.setOnAction(editor);

            TripPageHandler tripMaker = new TripPageHandler();
            trip.setOnAction(tripMaker);
            //The above three blocks call the handlers of the menu buttons when they are clicked.

            Scene scene = new Scene(rootVBox);
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
            //This is the call to start the GUI.

            RootApplication.refreshRoster();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void refreshRoster() throws IOException, ClassNotFoundException {
        outputToServer.writeObject(new GetRosterRequest());
        roster = (ArrayList<Profile>) inputFromServer.readObject();
    }
    //This calls the function to refresh the roster.

    public static void addChild(Profile profile) throws IOException, ClassNotFoundException {
        outputToServer.writeObject(new NewChildRequest(profile));
    }
    //This calls the function to add a child to the roster.

    public static void updateChild(Profile profile) throws IOException, ClassNotFoundException {
        outputToServer.writeObject(new UpdateChildRequest(profile));
    }
    //This calls the function to update a kids' information.

    public static Route getRoute(ArrayList<Profile> profiles) throws IOException, ClassNotFoundException {
        outputToServer.writeObject(new GetRouteRequest(profiles));
        return (Route) inputFromServer.readObject();
    }
    //This calls the function to generate the route.
}
