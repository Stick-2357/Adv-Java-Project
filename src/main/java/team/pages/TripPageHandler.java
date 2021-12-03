package team.pages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TripPageHandler implements EventHandler<ActionEvent> {
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
