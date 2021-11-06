package nl.hsleiden.controller;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import nl.hsleiden.service.ResultService;

public class ResultController {
    private static ResultController resultController;
    private final ResultService resultService;
    private final SceneController sceneController;
    private final ContentController contentController;

    private ResultController() {
        resultService = new ResultService();
        sceneController = SceneController.getInstance();
        contentController = ContentController.getInstance();
    }

    public synchronized static ResultController getInstance() {
        if(resultController == null) {
            resultController = new ResultController();
        }
        return resultController;
    }

    public void switchToNextScreen(String fileName) {
        sceneController.switchToNextScreen(fileName);
    }

    public void closeApplication(){
        try{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Close");
            alert.setHeaderText("Close program?");
            alert.showAndWait().filter(r -> r != ButtonType.CANCEL).ifPresent(r-> Platform.exit());
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void getResults() {
        resultService.getAll();
    }

    public void sendContent() {
        contentController.getContentById(contentController.getId());
    }

    public void showResultOnScreen(TextArea textArea, String text){
        textArea.setText(text);
    }
}
