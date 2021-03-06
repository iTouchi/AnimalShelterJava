package com.AnimalShelterJava;

import com.AnimalShelterJava.endpoint.GreeterClientEndpoint;
import domain.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;
import java.util.Observer;

public class WebsocketClient implements Observer {

    private static final Logger log = LoggerFactory.getLogger(WebsocketClient.class);

    public void start(String name, int age) {
        try {
            GreeterClientEndpoint greeterClientEndpoint = GreeterClientEndpoint.getInstance();
            greeterClientEndpoint.addObserver(this);
            greeterClientEndpoint.start();
            log.info("Websocket client started");

            greeterClientEndpoint.sendMessageToServer(new Greeting(name,age));

            greeterClientEndpoint.stop();
            log.info("Websocket client stopped");
        } catch (Exception ex) {
            log.error("Client couldn't start.");
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        log.info("Update called. {}", arg);
    }
}