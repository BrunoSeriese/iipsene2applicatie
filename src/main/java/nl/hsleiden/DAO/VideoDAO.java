package nl.hsleiden.DAO;

import nl.hsleiden.model.Video;

import java.util.ArrayList;

public class VideoDAO implements DAO<Video> {
    private final String api = "http://localhost:8080/videos";

    @Override
    public ArrayList<Video> getAll() {
        return null;
    }

    @Override
    public Video get() {
        return null;
    }
}
