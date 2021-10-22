package nl.hsleiden.DAO;

import nl.hsleiden.controller.ContentController;
import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Result;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO implements DAO<Result> {
    private final ContentController contentController;

    public ResultDAO(){
        contentController = ContentController.getInstance();
    }

    @Override
    public List<Result> getAll() {
        return null;
    }

    @Override
    public Result get(Long id) {
        return null;
    }

    @Override
    public Result create(Result result) {
        return null;
    }

    @Override
    public Result update(Long id) {
        return null;
    }

    @Override
    public void delete(Result result) {

    }

    public void getResults() throws IOException {
        JSONArray json = new JSONArray(IOUtils.toString(new URL("http://localhost:8080/results"), StandardCharsets.UTF_8));

        for (int i=0;i<json.length();i++){
            JSONObject result = (JSONObject) json.get(i);
            int rid = (int) result.get("id");
            String rvalue = (String) result.get("value");

            int aid = 0;
            String avalue = null;
            int acurrentContentId = 0;
            int anextContentId = 0;

            Answer newAnswer = new Answer(aid, avalue, acurrentContentId, anextContentId);

            Result newResult = new Result(rid, rvalue, newAnswer);
            contentController.addContent(newResult);

        }


    }
}
