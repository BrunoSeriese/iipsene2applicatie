package nl.hsleiden.controller;

import javafx.scene.web.WebView;
import nl.hsleiden.DAO.VideoDAO;
import nl.hsleiden.service.VideoService;

public class VideoController {
    private static VideoController videoController;
    private final VideoService videoService;

    private VideoController() {
        videoService = new VideoService();
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
