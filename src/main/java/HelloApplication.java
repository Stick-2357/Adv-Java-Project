import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    List<Child> roster = new ArrayList<Child>();

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

    public static void main(String[] args) {
        launch();
    }

    class RosterHandlerClass implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            TextField name = new TextField();
            TextField address = new TextField();
            TextField emergencyContact = new TextField();
            TextField emergencyEmail = new TextField();
            Label named = new Label();
            Stage stage2 = new Stage();

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

            create.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    named.setText("");

                    Child kid = new Child(name.getText(), address.getText(), emergencyContact.getText(), emergencyEmail.getText());

                    roster.add(kid);

                    name.clear();
                    address.clear();
                    emergencyContact.clear();
                    emergencyEmail.clear();

                    named.setText(kid.GetName() + " added to roster.");

                    pane2.add(named, 0, 6);
                }
            });

            Scene scene = new Scene(pane2);
            stage2.setTitle("Add to Roster Information");
            stage2.setScene(scene);
            stage2.show();
        }
    }

    class RosterEditHandlerClass implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            Stage stage3 = new Stage();

            Child helper = new Child();
            Button kid = new Button();
            int crap = 0;

            GridPane pane3 = new GridPane();
            pane3.setAlignment(Pos.CENTER);
            pane3.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

            for(int i = 0; i < roster.size(); i++){
                helper = roster.get(i);

                kid = new Button(helper.GetName());

                pane3.add(kid, 0, i);

                Button finalKid = kid;

                kid.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Child helped = new Child();
                        String names = finalKid.getText();
                        int needed = 0;

                        for(int i = 0; i < roster.size(); i++){
                            helped = roster.get(i);

                            if(names == helped.GetName()){
                                needed = i;
                                break;
                            }
                        }

                        final int maybe = needed;

                        TextField name = new TextField(helped.GetName());
                        TextField address = new TextField(helped.GetAddress());
                        TextField emergencyContact = new TextField(helped.GetPhone());
                        TextField emergencyEmail = new TextField(helped.GetEmail());

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

                        save.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                Child thisOne = new Child(name.getText(), address.getText(), emergencyContact.getText(), emergencyEmail.getText());

                                roster.set(maybe, thisOne);

                                name.clear();
                                address.clear();
                                emergencyContact.clear();
                                emergencyEmail.clear();
                            }
                        });
                    }
                });
            }

            Scene scene = new Scene(pane3);
            stage3.setTitle("Select Roster Member to Edit");
            stage3.setScene(scene);
            stage3.show();
        }
    }

    class TripHandlerClass implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
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

    private class Child{
        String name, address, phone, email;

        public Child(){
            name = "";
            address = "";
            phone = "";
            email = "";
        }

        public Child(String newName, String newAddress, String newPhone, String newEmail){
            name = newName;
            address = newAddress;
            phone = newPhone;
            email = newEmail;
        }

        public void SetName(String updateName){
            name = updateName;
        }

        public String GetName(){
            return name;
        }

        public void SetAddress(String updateAddress){
            address = updateAddress;
        }

        public String GetAddress(){
            return address;
        }

        public void SetPhone(String updatePhone){
            phone = updatePhone;
        }

        public String GetPhone(){
            return phone;
        }

        public void SetEmail(String updateEmail){
            email = updateEmail;
        }

        public String GetEmail(){
            return email;
        }
    }
}