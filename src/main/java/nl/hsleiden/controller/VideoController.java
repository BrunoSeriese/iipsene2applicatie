package nl.hsleiden.controller;

import nl.hsleiden.model.Video;

public class VideoController {
    private static VideoController videoController;

    public VideoController() {

    }

    public static VideoController getInstance() {
        if(videoController == null) {
            videoController = new VideoController();
        }
        return videoController;
    }
}
