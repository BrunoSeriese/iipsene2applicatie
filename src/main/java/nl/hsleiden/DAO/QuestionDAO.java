package nl.hsleiden.DAO;

import com.google.gson.Gson;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.model.Question;
import nl.hsleiden.service.HistoryService;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class QuestionDAO implements DAO<Question> {
    private static QuestionDAO questionDAO;



    public synchronized static QuestionDAO getInstance(){
        if (questionDAO == null) {
            questionDAO = new QuestionDAO();
        }
        return questionDAO;
    }

    @Override
    public List<Question> getAll() {
        return null;
    }

    @Override
    public Question get(Long id) {
        return null;
    }

    @Override
    public Question create(Question question) {
        return null;
    }

    @Override
    public Question update(Long id) {
        return null;
    }

    @Override
    public void delete(Question question) {

    }
    public void getQuestions() throws IOException {
        JSONArray json = new JSONArray(IOUtils.toString(new URL("http://localhost:8080/questions"), StandardCharsets.UTF_8));
//       Question[] questions = new Gson().fromJson(json.toString(), Question[].class);
//        System.out.println(questions);
    }
}
