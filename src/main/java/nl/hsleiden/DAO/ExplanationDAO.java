package nl.hsleiden.DAO;

import nl.hsleiden.controller.ContentController;
import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Explanation;
import nl.hsleiden.model.Question;
import nl.hsleiden.model.Video;
import nl.hsleiden.service.AnswerService;
import nl.hsleiden.service.ApiService;
import nl.hsleiden.service.ExplanationService;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ExplanationDAO implements DAO<Explanation> {
    private final String api = new ApiService().getApi();
    private final AnswerService answerService;
    private final ExplanationService explanationService;

    public ExplanationDAO(ExplanationService explanationService) {
        answerService = new AnswerService();
        this.explanationService = explanationService;
    }


    @Override
    public List<Explanation> getAll() {
        List<Explanation> explanations = new ArrayList<>();
        try {
            JSONArray json = new JSONArray(IOUtils.toString(new URL(api + "/explanations"), StandardCharsets.UTF_8));

            for (int i = 0; i < json.length(); i++) {
                JSONObject explanation = (JSONObject) json.get(i);
                Explanation newExplanation = explanationService.unpack(explanation);

                JSONObject answer = (JSONObject) explanation.get("answer");
                Answer newAnswer = answerService.unpack(answer);
                newExplanation.setAnswer(newAnswer);

                explanations.add(newExplanation);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return explanations;
    }

    @Override
    public Explanation get(Long id) {
        return null;
    }

    @Override
    public Explanation create(Explanation explanation) {
        return null;
    }

    @Override
    public Explanation update(Long id) {
        return null;
    }

    @Override
    public void delete(Explanation explanation) {

    }
}
