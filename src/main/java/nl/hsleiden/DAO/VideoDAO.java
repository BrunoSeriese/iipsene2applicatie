package nl.hsleiden.DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nl.hsleiden.model.Video;
import nl.hsleiden.service.ApiService;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO implements DAO<Video> {
    private final String api = new ApiService().getApi("/videos");

    @Override
    public List<Video> getAll() {
        List<Video> videos = new ArrayList<>();
        try {
            JSONArray json = new JSONArray(IOUtils.toString(new URL(api), StandardCharsets.UTF_8));
            Type type = new TypeToken<ArrayList<Video>>(){}.getType();
            videos = new Gson().fromJson(json.toString(), type);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return videos;
    }
}
