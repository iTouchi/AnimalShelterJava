package sample;

import Classes.Cat;
import Classes.Gender;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{


    public Button btnAddAnimal;
    public ComboBox cbSpecies;
    public TextField tbName;
    public Label labelGender;
    public ListView lbAnimals;


    public Cat simboe = new Cat("Simba", Gender.MALE,"Bites");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onClick(ActionEvent actionEvent) {

        String name = tbName.textProperty().get();
        labelGender.textProperty().set(name);
        lbAnimals.getItems().add(simboe);
    }
}


