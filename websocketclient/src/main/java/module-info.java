module websocketclient {
    exports com.AnimalShelterJava;
    exports com.AnimalShelterJava.endpoint;
    requires ApplicationLayer;
    requires slf4j.api;
    requires gson;
    requires javax.websocket.client.api;
    requires java.sql;
}