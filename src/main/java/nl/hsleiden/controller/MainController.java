package nl.hsleiden.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import nl.hsleiden.iipsene2applicatie.MainApplication;

public class MainController {
    private static MainController mainController;
    private final SceneController sceneController;

    public MainController(){
        sceneController = SceneController.getInstance();
    }

    public static MainController getInstance() {
        if (mainController == null) {
            mainController = new MainController();
        }
        return mainController;
    }

    public void switchToNextScreen(ActionEvent event, String fileName) throws IOException {
        sceneController.switchToNextScreen(event,fileName);
    }
}