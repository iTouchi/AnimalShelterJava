package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{


    public Button btnAddAnimal;
    public ComboBox cbSpecies;
    public TextField tbName;
    public Label label1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onClick(ActionEvent actionEvent) {

        String name = tbName.textProperty().get();
        label1.textProperty().set(name);

    }
}


