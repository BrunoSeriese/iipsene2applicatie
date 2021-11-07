package nl.hsleiden.controller;

import javafx.scene.web.WebView;

/**
 * Controls the Video(View & Model).
 * @author Hicham El Faquir, Ryan Bhola, Bruno Seriese
 */
public class VideoController {
    private static VideoController videoController;

    private VideoController() {
    }

    public synchronized static VideoController getInstance() {
        if(videoController == null) {
            videoController = new VideoController();
        }
        return videoController;
    }

    public void embedVideo(String url, WebView webView) {
        webView.getEngine().load(url);
    }
}
