//This is the menu for making the selections to generate the trip.
//A minimum of three roster members should be chosen for the best, simple, results.

package team.pages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import team.Profile;
import team.jsonobjects.Location;
import team.jsonobjects.Route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TripPageHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        Stage newStage = new Stage();
        VBox left = new VBox();
        VBox right = new VBox();
        HBox rootHBox = new HBox(left, right);

        VBox childrenVBox = new VBox();
        for (int i = 0; i < RootApplication.roster.size(); i++) {
            Profile child = RootApplication.roster.get(i);
            CheckBox childCheckbox = new CheckBox(child.getName());
            childCheckbox.setId(String.valueOf(child.getId()));
            childrenVBox.getChildren().add(childCheckbox);
            Label resultLabel = new Label("");
            right.getChildren().add(resultLabel);
        }
        //This creates the list of checkBoxes for selecting the roster members.

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
            //This creates a list of selected check boxes.
            try {
                Route route = RootApplication.getRoute(selectedChildren);
                for (Node node : right.getChildren()) {
                    if (node.getClass() == Label.class) {
                        ((Label) node).setText("");
                    }
                }

                ArrayList<Integer> order = route.getLocationSequence();
                for (int i = 0; i < order.size(); i++) {
                    ((Label) right.getChildren().get(i)).setText(selectedChildren.get(order.get(i)).getAddress());
                }
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            //This generates the route and displays it on the right side on the pane.
        });
        //This defines what happens when the User clicks the "Generate Route" button.

        left.getChildren().add(childrenVBox);
        left.getChildren().add(select);
        //These place the checkboxes and button on the left side of the pane.

        Scene scene = new Scene(rootHBox);
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
        //These start the display of the GenerateTrip stage.
    }
}
