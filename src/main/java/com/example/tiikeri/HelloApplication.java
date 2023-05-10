package com.example.tiikeri;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Image icon = new Image("file:/Users/benny/desktop/Tiikeri/src/icon.png");
        //Image icon = new Image(getClass().getResourceAsStream("com/example/tiikeri/icon.png"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.getIcons().add(icon);
        stage.setTitle("Tiikeri - Open Source Web-browser");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}