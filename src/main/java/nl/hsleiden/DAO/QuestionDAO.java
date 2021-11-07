package nl.hsleiden.DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nl.hsleiden.model.Question;
import nl.hsleiden.service.ApiService;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles all requests to the API for questions.
 * @author Vincent Severin
 */
public class QuestionDAO implements DAO<Question> {
    private final String api = new ApiService().getApi("/questions");

    @Override
    public List<Question> getAll() {
        List<Question> questions = new ArrayList<>();
        try {
            JSONArray json = new JSONArray(IOUtils.toString(new URL(api), StandardCharsets.UTF_8));
            Type type = new TypeToken<ArrayList<Question>>(){}.getType();
            questions = new Gson().fromJson(json.toString(), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
