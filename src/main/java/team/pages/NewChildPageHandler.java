//This allows the User to add a child to the roster.
//It stays active until the User closes it to return to the main menu.

package team.pages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import team.Profile;

import java.io.IOException;

public class NewChildPageHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        TextField name = new TextField();
        TextField address = new TextField();
        TextField emergencyContact = new TextField();
        TextField emergencyEmail = new TextField();
        Label named = new Label();
        Stage newStage = new Stage();
        //These create items that will be used to populate the stage for object creation.

        GridPane pane2 = new GridPane();
        pane2.setAlignment(Pos.CENTER);
        pane2.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        //This creates the pane that displays the Add Roster menu.

        pane2.add(new Label("Child Name:"), 0, 0);
        pane2.add(name, 1, 0);
        pane2.add(new Label("Address:"), 0, 1);
        pane2.add(address, 1, 1);
        pane2.add(new Label("Emergency Phone Number:"), 0, 2);
        pane2.add(emergencyContact, 1, 2);
        pane2.add(new Label("Emergency Email Address:"), 0, 3);
        pane2.add(emergencyEmail, 1, 3);
        pane2.add(named, 0, 6);
        Button create = new Button("Add to Roster");
        pane2.add(create, 1, 6);
        //These create, and layout, the page for object creation.

        create.setOnAction(actionEvent -> {
            named.setText("");
            //This empties a label that tells the User if their Profile object was added to the roster.

            Profile kid = new Profile(1, name.getText(), emergencyContact.getText(), emergencyEmail.getText(), address.getText());
            //This creates a new Profile object using what the User typed in the text boxes.

            try {
                RootApplication.addChild(kid);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            name.clear();
            address.clear();
            emergencyContact.clear();
            emergencyEmail.clear();
            //This clears the textBoxes after the Profile has been created.

            named.setText(kid.getName() + " added to roster.");
            //This puts text in a label letting the User know their Profile was created.
        });

        Scene scene = new Scene(pane2);
        newStage.setTitle("Add to Roster Information");
        newStage.setScene(scene);
        newStage.setOnCloseRequest((event -> {
            try {
                RootApplication.refreshRoster();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }));
        newStage.show();
        //These start the display of the AddRoster stage.
    }
}
