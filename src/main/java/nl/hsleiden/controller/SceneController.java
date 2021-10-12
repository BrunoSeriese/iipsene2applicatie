package nl.hsleiden.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.hsleiden.iipsene2applicatie.MainApplication;

import java.io.IOException;
import java.util.Objects;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToNextScreen(ActionEvent event, String fileName) throws IOException {
        root = FXMLLoader.load(MainApplication.class.getResource(fileName));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
