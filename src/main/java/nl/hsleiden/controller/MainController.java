package nl.hsleiden.controller;

public class MainController {
    private static MainController mainController;
    private final SceneController sceneController;

    private MainController() {
        sceneController = SceneController.getInstance();
    }

    public synchronized static MainController getInstance() {
        if (mainController == null) {
            mainController = new MainController();
        }
        return mainController;
    }

    public void switchToNextScreen(String fileName) {
        sceneController.switchToNextScreen(fileName);
    }
}