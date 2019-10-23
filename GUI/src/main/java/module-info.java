module PresentationLayer {

    requires ApplicationLayer;
    requires javafx.fxml;
    requires javafx.controls;

    requires gson;
    requires org.apache.httpcomponents.httpclient;
    requires slf4j.api;
    requires org.apache.httpcomponents.httpcore;
    requires java.sql;

    opens sample;
    exports sample;
}