package nl.hsleiden.controller;

import javafx.event.ActionEvent;

import java.io.IOException;

public class ExplanationController {
    private static ExplanationController explanationController;
    private final SceneController sceneController;

    public ExplanationController() {
        sceneController = SceneController.getInstance();
    }

    public static ExplanationController getInstance() {
        if(explanationController == null) {
            explanationController = new ExplanationController();
        }
        return explanationController;
    }

    public void switchToNextScreen(ActionEvent event, String fileName) throws IOException {
        sceneController.switchToNextScreen(event,fileName);
    }
}
