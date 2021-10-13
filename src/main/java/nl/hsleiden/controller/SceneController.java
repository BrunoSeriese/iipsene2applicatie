package nl.hsleiden.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.hsleiden.iipsene2applicatie.MainApplication;
import nl.hsleiden.view.View;

import java.io.IOException;
import java.util.Objects;

public class SceneController implements Controller{

    private Stage stage;
    private Scene scene;
    private Parent root;

    static SceneController sceneController;

    public SceneController(){

    }

    /**
     * With the getInstance() method, we can always make sure that there is only one instance running of this
     * controller. To use this method, create an empty SceneController variable outside the constructor of another
     * class. After that call the getInstance() method in the constructor like the example below.
     * @<code>
     *     SceneController sceneController;
     *
     *     public DifferentClass(){
     *         sceneController = SceneController.getInstance();
     *     }
     * </code>
     *
     * @author Hicham El Faquir
     */

    public static SceneController getInstance() {
        if (sceneController == null) {
            sceneController = new SceneController();
        }
        return sceneController;
    }

    public void switchToNextScreen(ActionEvent event, String fileName) throws IOException {
        root = FXMLLoader.load(MainApplication.class.getResource(fileName));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void registerObserver(View v) {

    }
}
