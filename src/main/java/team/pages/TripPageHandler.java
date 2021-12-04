package team.pages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import team.Profile;
import team.jsonobjects.Location;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TripPageHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        Stage newStage = new Stage();

        // TODO: populate from getAllProfiles
        VBox childrenVBox = new VBox();
        for (int i = 0; i < RootApplication.roster.size(); i++) {
            Profile child = RootApplication.roster.get(i);
            CheckBox childCheckbox = new CheckBox(child.getName());
            childCheckbox.setId(String.valueOf(child.getId()));
            childrenVBox.getChildren().add(childCheckbox);
        }

        Button select = new Button("Generate Route");
        select.setOnAction((event) -> {
            ArrayList<Profile> selectedChildren = new ArrayList<>();
            for (Node node : childrenVBox.getChildren()) {
                if (node.getClass() == CheckBox.class) { // deals with non-checkbox nodes
                    CheckBox checkBox = (CheckBox) node;
                    if (checkBox.isSelected()) {
                        int childID = Integer.parseInt(checkBox.getId());
                        Profile selectedChild = RootApplication.roster.stream().filter(c -> c.getId() == childID).collect(Collectors.toList()).get(0);
                        selectedChildren.add(selectedChild);
                    }
                }
            }
            try {
                List<Location> locations = RootApplication.getRoute(selectedChildren);
                System.out.println(locations);
                // TODO: Display route info
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        VBox pane4 = new VBox(childrenVBox, select);

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
