package nl.hsleiden.DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nl.hsleiden.model.Result;
import nl.hsleiden.service.ApiService;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO implements DAO<Result> {
    private final String api = new ApiService().getApi("/results");

    @Override
    public List<Result> getAll() {
        List<Result> results = new ArrayList<>();
        try {
            JSONArray json = new JSONArray(IOUtils.toString(new URL(api), StandardCharsets.UTF_8));
            Type type = new TypeToken<ArrayList<Result>>(){}.getType();
            results = new Gson().fromJson(json.toString(), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
}
