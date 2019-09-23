module AnimalShelterGUI {

    requires AnimalShelterCore;
    requires javafx.fxml;
    requires javafx.controls;

    opens sample;
    exports sample;
}