package nl.hsleiden.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.controller.VideoController;
import nl.hsleiden.model.Content;

import java.net.URL;
import java.util.ResourceBundle;

public class VideoView implements Initializable {

    private final VideoController videoController;

    @FXML
    public WebView webViewContainer;

    public VideoView() {
        videoController = VideoController.getInstance();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        embedVideo();
    }

    @FXML
    public void embedVideo() {
        Content content = ContentController.getInstance().getContent();
        String url = content.getValue();
        videoController.embedVideo(url, webViewContainer);
    }


}