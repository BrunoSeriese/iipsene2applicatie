package nl.hsleiden.service;

import nl.hsleiden.DAO.ResultDAO;
import nl.hsleiden.DAO.VideoDAO;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.model.Result;
import nl.hsleiden.model.Video;
import org.json.JSONObject;

import java.util.List;

public class VideoService {
    private final VideoDAO videoDAO;
    private final ContentController contentController;

    public VideoService() {
        videoDAO = new VideoDAO(this);
        contentController = ContentController.getInstance();
    }

    public Video unpack(JSONObject video) {
        int id = (int) video.get("id");
        String value = (String) video.get("value");
        return new Video(id, value);
    }

    public List<Video> getAll() {
        List<Video> videos = this.videoDAO.getAll();
        videos.forEach(contentController::addContent);
        return videos;
    }
}
