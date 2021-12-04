//This is the menu editing a previously entered roster member.
//It only allows the editing of one Profile at a time.

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
import java.util.Objects;
import java.util.stream.Collectors;

public class RosterPageHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        Stage newStage = new Stage();

        Profile child;
        Button childButton;
        //These set temp variables for ease of use later.

        GridPane pane3 = new GridPane();
        pane3.setAlignment(Pos.CENTER);
        pane3.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        //This creates the pane that displays the Edit Roster menu.

        for (int i = 0; i < RootApplication.roster.size(); i++) { // for each child
            child = RootApplication.roster.get(i);

            childButton = new Button(child.getName()); // make a button
            childButton.setId(child.getId().toString()); // TODO: add null case

            pane3.add(childButton, 0, i);
            //The above creates a button, sets its ID, and adds it to the pane.

            childButton.setOnAction(actionEvent -> { // on button click
                // TODO: get child by button id
                int childID = Integer.parseInt(((Button) actionEvent.getSource()).getId());
                Profile childClicked = RootApplication.roster.stream().filter(c -> c.getId() == childID).collect(Collectors.toList()).get(0);
                //This allows for access of the Profile object so its information can be displayed in the text boxes.

                TextField name = new TextField(childClicked.getName());
                TextField address = new TextField(childClicked.getAddress());
                TextField emergencyContact = new TextField(childClicked.getEmergencyNum());
                TextField emergencyEmail = new TextField(childClicked.getEmail());
                Label named = new Label();
                //These create name shortcuts for later use and populate them with the Profile elements.

                pane3.getChildren().clear();
                //Clears the pane to allow next options to appear.

                pane3.add(new Label("Child Name:"), 0, 0);
                pane3.add(name, 1, 0);
                pane3.add(new Label("Address:"), 0, 1);
                pane3.add(address, 1, 1);
                pane3.add(new Label("Emergency Phone Number:"), 0, 2);
                pane3.add(emergencyContact, 1, 2);
                pane3.add(new Label("Emergency Email Address:"), 0, 3);
                pane3.add(emergencyEmail, 1, 3);
                pane3.add(named, 0, 6);
                Button save = new Button("Save Edits");
                pane3.add(save, 1, 6);
                //These display everything needed to edit the roster Profile.
                //It mimics the AddRoster for ease of use and familiarities' sake.

                save.setOnAction(actionEvent1 -> {
                    named.setText("");
                    Profile thisOne = new Profile(childID, name.getText(), emergencyContact.getText(), emergencyEmail.getText(), address.getText());

                    try {
                        System.out.println("Sending update request");
                        RootApplication.updateChild(thisOne);
                    } catch (IOException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }

                    named.setText(thisOne.getName() + " has been updated.");

                    name.clear();
                    address.clear();
                    emergencyContact.clear();
                    emergencyEmail.clear();
                });
                //This saves the updated Profile in the roster.
            });
        }
        //This loops through adding Profile selections to the edit selection screen.
        //It also handles them being edited.

        Scene scene = new Scene(pane3);
        newStage.setTitle("Select Roster Member to Edit");
        newStage.setScene(scene);
        newStage.setOnCloseRequest((event -> {
            try {
                RootApplication.refreshRoster();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }));
        newStage.show();
        //These start the display of the EditRoster stage.
    }
}
