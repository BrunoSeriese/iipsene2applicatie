package nl.hsleiden.iipsene2applicatie;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import nl.hsleiden.controller.ContentController;

import java.io.IOException;

public class MainApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
//        stage.setOnCloseRequest(evt -> {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Confirm Close");
//            alert.setHeaderText("Close program?");
//            alert.showAndWait().filter(r -> r != ButtonType.OK).ifPresent(r->evt.consume());
//        });
        ContentController.getInstance().buildDatabase();
        stage.setTitle("Subsidiewijzer SVDJ");
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}