package com.timehub.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TimeHub extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TimeHub.class.getResource("fxml/Dashboard_UI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("TimeHub - Java Version");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}