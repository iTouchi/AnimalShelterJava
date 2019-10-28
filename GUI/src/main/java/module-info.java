module PresentationLayer {

    requires ApplicationLayer;
    requires javafx.fxml;
    requires javafx.controls;

    requires gson;
    requires org.apache.httpcomponents.httpclient;
    requires slf4j.api;
    requires org.apache.httpcomponents.httpcore;
    requires java.sql;
    requires javax.websocket.client.api;

    opens sample;
    exports sample;
}