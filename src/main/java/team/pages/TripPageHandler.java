package team.pages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import team.Profile;

import java.io.IOException;
import java.util.ArrayList;

public class TripPageHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        Stage newStage = new Stage();

        // TODO: populate from getAllProfiles
        ArrayList<CheckBox> children = new ArrayList<>();
        for (int i = 0; i < RootApplication.roster.size(); i++) {
            Profile child = RootApplication.roster.get(i);
            CheckBox childCheckbox = new CheckBox(child.getName());
            children.add(childCheckbox);
        }

        Button select = new Button("Generate Route");

        select.setOnAction((event) -> {
            // TODO: Call GetOptimizedRoute passing selected child locations
        });

        VBox pane4 = new VBox();
        for (CheckBox checkBox : children) {
            pane4.getChildren().add(checkBox);
        }
        pane4.getChildren().add(select);

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
