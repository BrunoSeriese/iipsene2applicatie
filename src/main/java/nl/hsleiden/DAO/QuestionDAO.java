package nl.hsleiden.DAO;



import nl.hsleiden.controller.ContentController;
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
        ArrayList listdata = new ArrayList();
        JSONArray json = new JSONArray(IOUtils.toString(new URL("http://localhost:8080/questions"), StandardCharsets.UTF_8));


            //Iterating JSON array
            for (int i=0;i<json.length();i++){

                //Adding each element of JSON array into ArrayList
                listdata.add(json.get(i));
                JSONObject newObj = (JSONObject) json.get(i);
                System.out.println(newObj.get("value"));
            }


    }
}
