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

        GridPane pane2 = new GridPane();
        pane2.setAlignment(Pos.CENTER);
        pane2.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

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

        create.setOnAction(actionEvent -> {
            named.setText("");

            Profile kid = new Profile(1, name.getText(), emergencyContact.getText(), emergencyEmail.getText(), address.getText());

            try {
                RootApplication.addChild(kid);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            name.clear();
            address.clear();
            emergencyContact.clear();
            emergencyEmail.clear();

            named.setText(kid.getName() + " added to roster.");
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
    }
}
