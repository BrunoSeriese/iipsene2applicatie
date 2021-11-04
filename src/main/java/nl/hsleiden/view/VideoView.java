package nl.hsleiden.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import nl.hsleiden.controller.VideoController;

import java.net.URL;
import java.util.ResourceBundle;

public class VideoView implements Initializable {

    private final VideoController videoController;

    public VideoView() {
        videoController = VideoController.getInstance();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.embedVideo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public WebView webViewContainer;

    @FXML
    public void embedVideo() throws InterruptedException {
        videoController.embedVideo("https://www.youtube.com/embed/f9vZeLHTgk4", webViewContainer);
    }
}