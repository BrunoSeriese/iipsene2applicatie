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
import nl.hsleiden.model.Main;
import nl.hsleiden.view.MainView;
import nl.hsleiden.view.View;

public class MainController {

    Main mainModel;
    SceneController sceneController;
    static MainController mainController;

    public MainController(){
        mainModel = new Main();
        sceneController = SceneController.getInstance();
    }

    public static MainController getInstance() {
        if (mainController == null) {
            mainController = new MainController();
        }
        return mainController;
    }

    public void registerObserver(View v){

        mainModel.registerObserver(v);
    }

    public void switchToNextScreen(ActionEvent event, String fileName) throws IOException {
        sceneController.switchToNextScreen(event,fileName);
    }


}