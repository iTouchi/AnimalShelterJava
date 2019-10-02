module ApplicationLayer {

    requires javafx.fxml;
    requires javafx.controls;

    exports domain.animal;
    exports domain.managers;
    exports domain.product;
    exports domain;
    exports DAL;

}