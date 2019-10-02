module PresentationLayer {

    requires ApplicationLayer;
    requires javafx.fxml;
    requires javafx.controls;

    opens sample;
    exports sample;
}