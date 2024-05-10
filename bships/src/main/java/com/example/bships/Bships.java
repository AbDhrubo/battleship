package com.example.bships;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Bships extends Application {


    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Bships.class.getResource("home.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 700);
//        stage.setTitle("Battleship");
//        stage.setScene(scene);
//        stage.show();
//    }
    public void start(Stage stage) throws Exception {
        FXMLLoader tempLoader = new FXMLLoader(Bships.class.getResource("temp-view.fxml"));
        Scene tempScene = new Scene(tempLoader.load(), 600, 700);

        stage.setTitle("Battleship");
        stage.setScene(tempScene);
        stage.show();

        // Delay transition to the main scene
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(e -> {
            try {
                loadMainScene(stage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        delay.play();
    }

    private void loadMainScene(Stage stage) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(Bships.class.getResource("home.fxml"));
        Scene mainScene = new Scene(mainLoader.load(), 600, 700);

        stage.setTitle("PokéDex");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}