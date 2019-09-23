package sample;

import Classes.*;
import Classes.Gender;
import Classes.Reservation;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public Button btnAddAnimal;
    public ComboBox cbSpecies;
    public TextField tbName;
    public TextField tbBadHabits;
    public Label labelGender;
    public ListView lbAnimals;
    public RadioButton rbMale;
    public RadioButton rbFemale;


    public Reservation reservation = new Reservation();


    public String name;
    public Gender gender;
    public String badHabits;
    public Cat cat;
    public Dog dog;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addAnimalOnClick(ActionEvent actionEvent) {

        String species = cbSpecies.getSelectionModel().getSelectedItem().toString();

        name = tbName.textProperty().get();
        badHabits = tbBadHabits.textProperty().get();

//        lbAnimals.getItems().add(simboe);

        if (species.equals("Cat")) {
//            cat.setBadHabits(badHabits);
//            cat.setGender(gender);
//            cat.setName(name);
            reservation.newCat(name, gender, badHabits);

        } else if (species.equals("Dog")) {
            dog.setGender(gender);
            dog.setName(name);
            reservation.Animals.add(dog);
        } else {
            labelGender.textProperty().set("Select Species");
        }

        lbAnimals.getItems().clear();
        reservation.Animals.forEach((n) ->  lbAnimals.getItems().add(n));



    }

    public void RadioButtonFemaleOnClick(ActionEvent actionEvent) {
        rbMale.setSelected(false);
        rbFemale.setSelected(true);
        gender = Gender.FEMALE;
    }

    public void RadioButtonMaleOnClick(ActionEvent actionEvent) {
        rbMale.setSelected(true);
        rbFemale.setSelected(false);
        gender = Gender.MALE;
    }

    public void onClickAddReservor(ActionEvent actionEvent) {
    }
}


