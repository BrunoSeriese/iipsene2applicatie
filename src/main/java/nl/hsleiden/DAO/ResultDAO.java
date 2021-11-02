package nl.hsleiden.DAO;

import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Result;
import nl.hsleiden.service.AnswerService;
import nl.hsleiden.service.ApiService;
import nl.hsleiden.service.ResultService;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO implements DAO<Result> {
    private final String api = new ApiService().getApi();
    private final AnswerService answerService;
    private final ResultService resultService;

    public ResultDAO(ResultService resultService) {
        answerService = new AnswerService();
        this.resultService = resultService;
    }

    @Override
    public List<Result> getAll() {
        List<Result> results = new ArrayList<>();
        try {
            JSONArray json = new JSONArray(IOUtils.toString(new URL(api + "/results"), StandardCharsets.UTF_8));

            for (int i = 0; i < json.length(); i++) {
                JSONObject result = (JSONObject) json.get(i);
                Result newResult = resultService.unpack(result);

                JSONObject answer = (JSONObject) result.get("answer");
                Answer newAnswer = answerService.unpack(answer);
                newResult.setAnswer(newAnswer);

                results.add(newResult);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return results;
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
}
