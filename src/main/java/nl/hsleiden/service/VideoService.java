package nl.hsleiden.service;

import nl.hsleiden.DAO.VideoDAO;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.model.Video;

import java.util.List;

/**
 * Contains code that shouldn't be on the Controller or DAO.
 * @author Vincent Severin
 */
public class VideoService {
    private final VideoDAO videoDAO;
    private final ContentController contentController;

    public VideoService() {
        videoDAO = new VideoDAO();
        contentController = ContentController.getInstance();
    }

    public List<Video> getAll() {
        List<Video> videos = this.videoDAO.getAll();
        videos.forEach(contentController::addContent);
        return videos;
    }
}
