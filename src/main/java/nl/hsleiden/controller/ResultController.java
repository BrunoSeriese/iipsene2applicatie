package nl.hsleiden.controller;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import nl.hsleiden.service.ResultService;

/**
 * Controls the Result(View & Model).
 * @author Hicham El Faquir, Ryan Bhola, Bruno Seriese
 */
public class ResultController {
    private static ResultController resultController;
    private final ResultService resultService;

    private ResultController() {
        resultService = new ResultService();
    }

    public synchronized static ResultController getInstance() {
        if(resultController == null) {
            resultController = new ResultController();
        }
        return resultController;
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

}
