package nl.hsleiden.controller;

import javafx.event.ActionEvent;
import nl.hsleiden.service.ExplanationService;

import java.io.IOException;

public class ExplanationController {
    private static ExplanationController explanationController;
    private final ExplanationService explanationService;
    private final SceneController sceneController;
    private final ContentController contentController;

    private ExplanationController() {
        explanationService = new ExplanationService();
        sceneController = SceneController.getInstance();
        contentController = ContentController.getInstance();
    }

    public synchronized static ExplanationController getInstance() {
        if (explanationController == null) {
            explanationController = new ExplanationController();
        }
        return explanationController;
    }

    public void sendNextContent() {
        contentController.nextContent();
    }

    public void switchToNextScreen(ActionEvent event, String fileName) throws IOException {
        sceneController.switchToNextScreen(fileName);
    }
}
