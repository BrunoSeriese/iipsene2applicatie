package nl.hsleiden.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import nl.hsleiden.controller.VideoController;
import nl.hsleiden.observer.VideoObserver;
import nl.hsleiden.subject.VideoSubject;

import java.net.URL;
import java.util.ResourceBundle;

public class VideoView implements VideoObserver, Initializable {

    private final VideoController videoController;

    public VideoView() {
        videoController = VideoController.getInstance();

    }

    @FXML
    public WebView webViewContainer;

    @Override
    public void update(VideoSubject state) {

    }

    @FXML
    public void embedVideo() throws InterruptedException {
        videoController.embedVideo("https://www.youtube.com/embed/f9vZeLHTgk4", webViewContainer);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.embedVideo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}