package nl.hsleiden.controller;

import javafx.event.ActionEvent;

import java.io.IOException;

public class MainController {
    private static MainController mainController;
    private final SceneController sceneController;

    public MainController() {
        sceneController = SceneController.getInstance();
    }

    public static MainController getInstance() {
        if (mainController == null) {
            mainController = new MainController();
        }
        return mainController;
    }

    public void switchToNextScreen(ActionEvent event, String fileName) throws IOException {
        sceneController.switchToNextScreen(event, fileName);
    }
}