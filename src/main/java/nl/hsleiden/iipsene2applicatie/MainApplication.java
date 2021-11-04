package nl.hsleiden.iipsene2applicatie;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.service.StageService;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        ContentController.getInstance().buildDatabase();

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);

        stage = setupStage(stage);
        stage.setTitle("Subsidiewijzer SVDJ");
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();
    }

    private Stage setupStage(Stage stage) {
        stage = StageService.getInstance().setCloseRequest(stage);
        StageService.getInstance().setStage(stage);
        return stage;
    }

    public static void main(String[] args) {
        launch();
    }
}