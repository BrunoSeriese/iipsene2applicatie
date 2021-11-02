package nl.hsleiden.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.hsleiden.iipsene2applicatie.MainApplication;
import nl.hsleiden.service.StageService;

import java.io.IOException;

public class SceneController {
    private static SceneController sceneController;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private SceneController() {

    }

    /**
     * With the getInstance() method, we can always make sure that there is only one instance running of this
     * controller. To use this method, create an empty SceneController variable outside the constructor of another
     * class. After that call the getInstance() method in the constructor like the example below.
     *
     * @<code> SceneController sceneController;
     * <p>
     * public DifferentClass(){
     * sceneController = SceneController.getInstance();
     * }
     * </code>
     * @author Hicham El Faquir
     */

    public synchronized static SceneController getInstance() {
        if (sceneController == null) {
            sceneController = new SceneController();
        }
        return sceneController;
    }

    public void switchToNextScreen(String fileName){
        try {
            root = FXMLLoader.load(MainApplication.class.getResource(fileName));
            stage = StageService.getInstance().getStage();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
