package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends Application {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Animal Shelter");
        primaryStage.setScene(new Scene(root, 1000, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

//        SimpleRestClient client = new SimpleRestClient();
//        final String key = "Leon";
//        final int age = 88;
//
//        // Post new greeting
//        Greeting greeting = client.postGreeting(new Greeting(key, age));
//        logGreeting(greeting);
//
//        // Get a greeting
//        greeting = client.getGreeting(key);
//        logGreeting(greeting);
    }

//    private static void logGreeting(Greeting greeting) {
//        if (greeting != null) {
//            log.info("{} {}", greeting.getName(), greeting.getAge());
//        } else {
//            log.info("No greeting found.");
//        }
//    }

}
