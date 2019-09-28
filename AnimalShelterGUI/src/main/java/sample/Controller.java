package sample;

import Classes.Animal;
import Classes.AnimalFactory;
import Classes.Gender;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ComboBox cbSpecies;
    public TextField tfName;
    public Label lbGender;
    public RadioButton rbMale;
    public RadioButton rbFemale;
    public TextField tfBadHabits;
    public Button btnAddAnimal;
    public Label lbAnimals;
    public ListView lvAnimals;
    public TextField tfReservorName;
    public Button btnReserveAnimal;

    private AnimalFactory animalFactory = new AnimalFactory();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lvAnimals.getItems().addAll(animalFactory.loadAnimals());
        tfBadHabits.setEditable(false);
//        tfReservorName.setEditable(false);
//        btnReserveAnimal.setDisable(true);
    }

    public void OnClickAddAnimal(ActionEvent actionEvent) {
        if (checkFields()){
            this.createAnimal();
            this.refreshControls();
        }
    }

    public void OnActionAddReservor(ActionEvent actionEvent) {
        Animal animal = (Animal) lvAnimals.getSelectionModel().getSelectedItem();

        if (animal != null) {
            animal.reserve(tfReservorName.getText());
            this.refreshControls();
        }
    }

    public void OnActionRbMale(ActionEvent actionEvent) {
        rbFemale.setSelected(false);
    }

    public void OnActionRbFemale(ActionEvent actionEvent) {
        rbMale.setSelected(false);
    }

    private void refreshControls()    {
        lvAnimals.getItems().clear();
        animalFactory.saveAnimals();
        animalFactory.loadAnimals();
        lvAnimals.getItems().addAll(animalFactory.getAnimals());
        tfBadHabits.clear();
        tfName.clear();
    }

    private void createAnimal() {

        String species = cbSpecies.getSelectionModel().getSelectedItem().toString();
        String name = tfName.getText();
        String badHabits = tfBadHabits.getText();
        Gender gender = getGender();


        if (species.equals("Cat")) {
            animalFactory.createCat(name, gender, badHabits);
        } else if (species.equals("Dog")) {
            animalFactory.createDog(name, gender);
        }
    }

    private Gender getGender() {
        if (rbFemale.isSelected()) {
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }

    public void onActionDelete(ActionEvent actionEvent) {
        Animal animal = (Animal) lvAnimals.getSelectionModel().getSelectedItem();

        if (animal != null) {
            animalFactory.deleteAnimal(animal);
            this.refreshControls();
        }
    }

    public boolean checkFields() {
            String species = cbSpecies.getSelectionModel().getSelectedItem().toString();


        if (species.equals("Cat") && tfName.getText().isEmpty() == false && tfBadHabits.getText().isEmpty() == false)  {
            if(rbFemale.isSelected() || rbMale.isSelected()){
                return true;
            }
        }
        if (species.equals("Dog") && tfName.getText().isEmpty() == false) {
            if(rbFemale.isSelected()|| rbMale.isSelected()){
                return true;
            }
        }
        return false;
    }

    public void OnActionSpecies(ActionEvent actionEvent) {
        if (cbSpecies.getSelectionModel().isSelected(0)){
            tfBadHabits.setEditable(true);
        }
        else{
            tfBadHabits.setEditable(false);
            tfBadHabits.clear();
        }

    }

    public void OnClickedListView(MouseEvent mouseEvent) {
//        tfReservorName.setEditable(true);
//        btnReserveAnimal.setDisable(false);
    }
}
