import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    List<Profile> roster = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Button create = new Button("Create Roster");
        Button edit = new Button("Edit Roster");
        Button trip = new Button("Create Trip");

        HBox pane = new HBox(create, edit, trip);
        pane.setAlignment(Pos.CENTER);

        NewChildHandlerClass roster = new NewChildHandlerClass();
        create.setOnAction(roster);

        RosterHandlerClass editor = new RosterHandlerClass();
        edit.setOnAction(editor);

        TripHandlerClass tripMaker = new TripHandlerClass();
        trip.setOnAction(tripMaker);

        Scene scene = new Scene(pane);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    class NewChildHandlerClass implements EventHandler<ActionEvent> {
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

                Profile kid = new Profile(1, name.getText(), address.getText(), emergencyContact.getText(), emergencyEmail.getText());

                roster.add(kid);

                name.clear();
                address.clear();
                emergencyContact.clear();
                emergencyEmail.clear();

                named.setText(kid.getName() + " added to roster.");

                pane2.add(named, 0, 6);
            });

            Scene scene = new Scene(pane2);
            newStage.setTitle("Add to Roster Information");
            newStage.setScene(scene);
            newStage.show();
        }
    }

    class RosterHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Stage newStage = new Stage();

            Profile child;
            Button childButton;

            GridPane pane3 = new GridPane();
            pane3.setAlignment(Pos.CENTER);
            pane3.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

            for (int i = 0; i < roster.size(); i++) { // for each child
                child = roster.get(i);

                childButton = new Button(child.getName()); // make a button
                // TODO: store DB idea in button id
//                childButton.setId(child.getId().toString()); // TODO: add null case

                pane3.add(childButton, 0, i);

                Button finalKid = childButton;

                childButton.setOnAction(actionEvent -> { // on button click
                    // TODO: get child by button id
//                    System.out.println(((Button) actionEvent.getSource()).getId());
                    Profile helped = new Profile();
                    String names = finalKid.getText();
                    int needed = 0;

                    for (int i1 = 0; i1 < roster.size(); i1++) {
                        helped = roster.get(i1);

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

                        roster.set(maybe, thisOne);

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

    class TripHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Stage newStage = new Stage();

            // TODO: populate from getAllProfiles

            CheckBox but1 = new CheckBox("Child 1");
            CheckBox but2 = new CheckBox("Child 2");
            CheckBox but3 = new CheckBox("Child 3");
            CheckBox but4 = new CheckBox("Child 4");
            CheckBox but5 = new CheckBox("Child 5");
            CheckBox but6 = new CheckBox("Child 6");
            CheckBox but7 = new CheckBox("Child 7");
            CheckBox but8 = new CheckBox("Child 8");
            Button select = new Button("Generate Route");

            select.setOnAction((event) -> {
                // TODO: Call GetOptimizedRoute passing selected child locations
            });

            VBox pane4 = new VBox(but1, but2, but3, but4, but5, but6, but7, but8, select);

            Scene scene = new Scene(pane4);
            newStage.setTitle("Select Member's for Trip");
            newStage.setScene(scene);
            newStage.show();
        }
    }
}
