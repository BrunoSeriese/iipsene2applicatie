package nl.hsleiden.controller;

import javafx.scene.web.WebView;
import nl.hsleiden.DAO.VideoDAO;
import nl.hsleiden.service.VideoService;

public class VideoController {
    private static VideoController videoController;
    private final VideoDAO videoDAO;
    private final VideoService videoService;

    public VideoController(VideoDAO videoDAO,
                           VideoService videoService) {
        this.videoDAO = videoDAO;
        this.videoService = videoService;
    }

    public static VideoController getInstance() {
        if (videoController == null) {
            videoController = new VideoController(new VideoDAO(), new VideoService());
        }
        return videoController;
    }

    public void embedVideo(String url, WebView webView) {
        webView.getEngine().load(url);
    }
}
