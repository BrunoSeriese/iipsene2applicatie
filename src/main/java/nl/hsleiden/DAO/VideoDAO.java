package nl.hsleiden.DAO;

import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Video;
import nl.hsleiden.service.AnswerService;
import nl.hsleiden.service.ApiService;
import nl.hsleiden.service.VideoService;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO implements DAO<Video> {
    private final String api = new ApiService().getApi();
    private final AnswerService answerService;
    private final VideoService videoService;

    public VideoDAO(VideoService videoService) {
        answerService = new AnswerService();
        this.videoService = videoService;
    }

    @Override
    public List<Video> getAll() {
        List<Video> videos = new ArrayList<>();
        try {
            JSONArray json = new JSONArray(IOUtils.toString(new URL(api + "/videos"), StandardCharsets.UTF_8));

            for (int i = 0; i < json.length(); i++) {
                JSONObject video = (JSONObject) json.get(i);
                Video newVideo = videoService.unpack(video);

                JSONObject answer = (JSONObject) video.get("answer");
                Answer newAnswer = answerService.unpack(answer);
                newVideo.setAnswer(newAnswer);

                videos.add(newVideo);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return videos;
    }

    @Override
    public Video get(Long id) {
        return null;
    }
}
