package nl.hsleiden.controller;

import nl.hsleiden.DAO.VideoDAO;
import nl.hsleiden.model.Video;

public class VideoController {
    private static VideoController videoController;
    private final VideoDAO videoDAO;

    public VideoController(VideoDAO videoDAO) {
        this.videoDAO = videoDAO;
    }

    public static VideoController getInstance() {
        if(videoController == null) {
            videoController = new VideoController(new VideoDAO());
        }
        return videoController;
    }
}
