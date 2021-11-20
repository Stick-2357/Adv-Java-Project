import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        //HBox pane = new HBox(10);
        //pane.setAlignment(Pos.CENTER);

        Button create = new Button("Create Roster");
        Button edit = new Button("Edit Roster");
        Button trip = new Button("Create Trip");

        HBox pane = new HBox(create, edit, trip);
        pane.setAlignment(Pos.CENTER);

        RosterHandlerClass roster = new RosterHandlerClass();
        create.setOnAction(roster);

        RosterEditHandlerClass editor = new RosterEditHandlerClass();
        edit.setOnAction(editor);

        TripHandlerClass tripMaker = new TripHandlerClass();
        trip.setOnAction(tripMaker);

        Scene scene = new Scene(pane);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    class RosterHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            TextField firstName = new TextField();
            TextField lastName = new TextField();
            TextField middleInit = new TextField();
            TextField address = new TextField();
            TextField emergencyRelation = new TextField();
            TextField emergencyContact = new TextField();
            Stage stage2 = new Stage();

            GridPane pane2 = new GridPane();
            pane2.setAlignment(Pos.CENTER);
            pane2.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

            pane2.add(new Label("First Name:"), 0, 0);
            pane2.add(firstName, 1, 0);
            pane2.add(new Label("Middle Initial:"), 0, 1);
            pane2.add(middleInit, 1, 1);
            pane2.add(new Label("Last Name:"), 0, 2);
            pane2.add(lastName, 1, 2);
            pane2.add(new Label("Address:"), 0, 3);
            pane2.add(address, 1, 3);
            pane2.add(new Label("Emergency Contact Relation:"), 0, 4);
            pane2.add(emergencyRelation, 1, 4);
            pane2.add(new Label("Emergency Contact:"), 0, 5);
            pane2.add(emergencyContact, 1, 5);
            Button create = new Button("Add to Roster");
            pane2.add(create, 1, 6);

            Scene scene = new Scene(pane2);
            stage2.setTitle("Add to Roster Information");
            stage2.setScene(scene);
            stage2.show();
        }
    }

    class RosterEditHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Stage stage3 = new Stage();

            Button but1 = new Button("Child 1");
            Button but2 = new Button("Child 2");
            Button but3 = new Button("Child 3");
            Button but4 = new Button("Child 4");
            Button but5 = new Button("Child 5");
            Button but6 = new Button("Child 6");
            Button but7 = new Button("Child 7");
            Button but8 = new Button("Child 8");

            VBox pane3 = new VBox(but1, but2, but3, but4, but5, but6, but7, but8);

            Scene scene = new Scene(pane3);
            stage3.setTitle("Select Roster Member to Edit");
            stage3.setScene(scene);
            stage3.show();
        }
    }

    class TripHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Stage stage4 = new Stage();

            CheckBox but1 = new CheckBox("Child 1");
            CheckBox but2 = new CheckBox("Child 2");
            CheckBox but3 = new CheckBox("Child 3");
            CheckBox but4 = new CheckBox("Child 4");
            CheckBox but5 = new CheckBox("Child 5");
            CheckBox but6 = new CheckBox("Child 6");
            CheckBox but7 = new CheckBox("Child 7");
            CheckBox but8 = new CheckBox("Child 8");
            Button select = new Button("Generate Route");

            VBox pane4 = new VBox(but1, but2, but3, but4, but5, but6, but7, but8, select);

            Scene scene = new Scene(pane4);
            stage4.setTitle("Select Member's for Trip");
            stage4.setScene(scene);
            stage4.show();
        }
    }
}
