package nl.hsleiden.controller;

import nl.hsleiden.service.ExplanationService;

/**
 * Controls the Explantion(View & Model).
 * @author Hicham El Faquir, Ryan Bhola, Bruno Seriese
 */
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

    public void switchToNextScreen(String fileName) {
        sceneController.switchToNextScreen(fileName);
    }
}
