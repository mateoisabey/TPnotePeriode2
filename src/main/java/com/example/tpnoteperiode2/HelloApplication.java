package com.example.tpnoteperiode2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("IHM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 200);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.resizableProperty().setValue(Boolean.FALSE);
        scene.setFill(Color.LIGHTGRAY);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}