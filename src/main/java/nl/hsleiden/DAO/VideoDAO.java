package nl.hsleiden.DAO;

import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Result;
import nl.hsleiden.model.Video;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class VideoDAO implements DAO<Video> {
    @Override
    public List<Video> getAll() {
        return null;
    }

    @Override
    public Video get(Long id) {
        return null;
    }

    @Override
    public Video create(Video video) {
        return null;
    }

    @Override
    public Video update(Long id) {
        return null;
    }

    @Override
    public void delete(Video video) {

    }

    public void getVideos() throws IOException {
        JSONArray json = new JSONArray(IOUtils.toString(new URL("http://localhost:8080/videos"), StandardCharsets.UTF_8));

        for (int i=0;i<json.length();i++){
            JSONObject video = (JSONObject) json.get(i);
            int vid = (int) video.get("id");
            String vvalue = (String) video.get("value");

            JSONObject answer = (JSONObject) video.get("answer");
            int aid = (int) answer.get("id");
            String avalue = (String) answer.get("value");
            int acurrentContentId = (int) answer.get("currentContentId");
            int anextContentId = (int) answer.get("nextContentId");

            Answer newAnswer = new Answer(aid, avalue, acurrentContentId, anextContentId);

            Video newVideo = new Video(vid, vvalue, newAnswer);

        }


    }
}
