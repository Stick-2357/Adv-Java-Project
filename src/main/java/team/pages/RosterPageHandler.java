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

public class RosterPageHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        Stage newStage = new Stage();

        Profile child;
        Button childButton;

        GridPane pane3 = new GridPane();
        pane3.setAlignment(Pos.CENTER);
        pane3.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

        for (int i = 0; i < RootApplication.roster.size(); i++) { // for each child
            child = RootApplication.roster.get(i);

            childButton = new Button(child.getName()); // make a button
            // TODO: store DB id in button id
            childButton.setId(child.getId().toString()); // TODO: add null case

            pane3.add(childButton, 0, i);

            Button finalKid = childButton;

            childButton.setOnAction(actionEvent -> { // on button click
                // TODO: get child by button id
                System.out.println(((Button) actionEvent.getSource()).getId());
                Profile helped = new Profile();
                String names = finalKid.getText();
                int needed = 0;

                for (int i1 = 0; i1 < RootApplication.roster.size(); i1++) {
                    helped = RootApplication.roster.get(i1);

                    if (Objects.equals(names, helped.getName())) {
                        needed = i1;
                        break;
                    }
                }

                final int maybe = needed;

                TextField name = new TextField(helped.getName());
                TextField address = new TextField(helped.getAddress());
                TextField emergencyContact = new TextField(helped.getEmergencyNum());
                TextField emergencyEmail = new TextField(helped.getEmail());

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
                Button save = new Button("Save Edits");
                pane3.add(save, 1, 6);

                save.setOnAction(actionEvent1 -> {
                    Profile thisOne = new Profile(null, name.getText(), address.getText(), emergencyContact.getText(), emergencyEmail.getText());

                    try {
                        RootApplication.updateChild(thisOne);
                    } catch (IOException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }

                    name.clear();
                    address.clear();
                    emergencyContact.clear();
                    emergencyEmail.clear();
                });
            });
        }

        Scene scene = new Scene(pane3);
        newStage.setTitle("Select Roster Member to Edit");
        newStage.setScene(scene);
        newStage.show();
    }
}
