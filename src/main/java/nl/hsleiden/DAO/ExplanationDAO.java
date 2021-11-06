package nl.hsleiden.DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nl.hsleiden.model.Explanation;
import nl.hsleiden.service.ApiService;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ExplanationDAO implements DAO<Explanation> {
    private final String api = new ApiService().getApi("/explanations");

    @Override
    public List<Explanation> getAll() {
        List<Explanation> explanations = new ArrayList<>();
        try {
            JSONArray json = new JSONArray(IOUtils.toString(new URL(api), StandardCharsets.UTF_8));
            Type type = new TypeToken<ArrayList<Explanation>>(){}.getType();
            explanations = new Gson().fromJson(json.toString(), type);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return explanations;
    }
}
