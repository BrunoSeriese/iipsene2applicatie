package nl.hsleiden.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import nl.hsleiden.DAO.ResultDAO;
import nl.hsleiden.service.ResultService;

import java.io.IOException;

public class ResultController {
    private static ResultController resultController;
    private final ResultDAO resultDAO;
    private final ResultService resultService;
    private final SceneController sceneController;

    private ResultController(ResultDAO resultDAO, ResultService resultService) {
        this.resultDAO = resultDAO;
        this.resultService = resultService;

        sceneController = SceneController.getInstance();
    }

    public synchronized static ResultController getInstance() {
        if(resultController == null) {
            resultController = new ResultController(new ResultDAO(), new ResultService());
        }
        return resultController;
    }

    public void switchToNextScreen(ActionEvent event, String fileName) throws IOException {
        sceneController.switchToNextScreen(event, fileName);

    }

    public void closeGame(){
        try{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Close");
            alert.setHeaderText("Close program?");
            alert.showAndWait().filter(r -> r != ButtonType.CANCEL).ifPresent(r-> Platform.exit());
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
