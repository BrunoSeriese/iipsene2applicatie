package nl.hsleiden.DAO;



import nl.hsleiden.controller.ContentController;
import nl.hsleiden.controller.SceneController;
import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Question;
import nl.hsleiden.service.HistoryService;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO implements DAO<Question> {
    private static QuestionDAO questionDAO;
    private final ContentController contentController;

    public QuestionDAO(){
    contentController = ContentController.getInstance();

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

    public void getQuestions() {
        try {
            JSONArray json = new JSONArray(IOUtils.toString(new URL("http://localhost:8080/questions"), StandardCharsets.UTF_8));
            for (int i=0;i<json.length();i++){
                JSONObject newObj = (JSONObject) json.get(i);
                int questionID = (int) newObj.get("id");
                String value = (String) newObj.get("value");
                JSONArray answers = (JSONArray) newObj.get("answers");
                ArrayList<Answer> questionAnswers = new ArrayList<>();

                for (int j = 0; j<answers.length();j++){
                    JSONObject currentAnswer = (JSONObject) answers.get(j);
                    int aid = (int) currentAnswer.get("id");
                    String avalue = (String) currentAnswer.get("value");
                    int acurrentContentId = (int) currentAnswer.get("currentContentId");
                    int anextContentId = (int) currentAnswer.get("nextContentId");
                    questionAnswers.add(new Answer(aid,avalue,acurrentContentId,anextContentId));
                }
                contentController.addContent(new Question(questionID,value,questionAnswers));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
