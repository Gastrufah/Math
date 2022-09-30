package com.app.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller_Main {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button goToMatrixScreen;
    @FXML
    private Button goToTestScreen;

    @FXML
    void initialize() {
        goToMatrixScreen.setOnAction(actionEvent -> {
            Main.screenController.activate("matrixScreen");
        });
        goToTestScreen.setOnAction(actionEvent -> {
            Main.screenController.activate("testScreen");
        });
    }

}
