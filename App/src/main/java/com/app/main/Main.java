package com.app.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static ScreenController screenController;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 780);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
        screenController = new ScreenController(scene);
        screenController.addScreen("mainScreen", FXMLLoader.load(getClass().getResource( "Main-screen.fxml" )));
        screenController.addScreen("matrixScreen", FXMLLoader.load(getClass().getResource( "Matrix-screen.fxml" )));
        screenController.addScreen("testScreen", FXMLLoader.load(getClass().getResource( "Test-screen.fxml" )));
        screenController.activate("mainScreen");
    }

    public static void main(String[] args) {
        launch();
    }

}