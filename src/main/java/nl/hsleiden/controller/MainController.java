package nl.hsleiden.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.io.IOException;
import javafx.event.ActionEvent;
public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea myText;
    SceneController sceneController = new SceneController();


    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {
        //TODO zet hier een verwijzing naar het openen van het volgende scherm

        sceneController.switchToNextScreen(event,"hello-view.fxml");
    }
}