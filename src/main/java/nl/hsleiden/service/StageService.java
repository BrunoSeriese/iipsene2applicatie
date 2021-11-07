package nl.hsleiden.service;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * Makes it possible to get the Stage from anywhere in the code, even without an ActionEvent.
 * @author Vincent Severin, Hicham El Faquir, Ryan Bhola
 */
public class StageService {
    private static StageService stageService;
    private Stage stage;

    private StageService() {

    }

    public synchronized static StageService getInstance() {
        if(stageService == null) {
            stageService = new StageService();
        }
        return stageService;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage setCloseRequest(Stage stage) {
        stage.setOnCloseRequest(evt -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Close");
            alert.setHeaderText("Close program?");
            alert.showAndWait().filter(r -> r != ButtonType.OK).ifPresent(r -> evt.consume());
        });
        return stage;
    }
}
