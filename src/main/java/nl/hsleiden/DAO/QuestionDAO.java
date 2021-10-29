package nl.hsleiden.DAO;

import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Question;
import nl.hsleiden.service.AnswerService;
import nl.hsleiden.service.ApiService;
import nl.hsleiden.service.QuestionService;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO implements DAO<Question> {
    private final String api = new ApiService().getApi();
    private final AnswerService answerService;
    private final QuestionService questionService;

    public QuestionDAO(QuestionService questionService) {
        answerService = new AnswerService();
        this.questionService = questionService;
    }

    @Override
    public List<Question> getAll() {
        List<Question> questions = new ArrayList<>();
        String api = this.api + "/questions";
        try {
            JSONArray json = new JSONArray(IOUtils.toString(new URL(api), StandardCharsets.UTF_8));
            for (int i = 0; i < json.length(); i++) {
                JSONObject question = (JSONObject) json.get(i);
                Question newQuestion = questionService.unpack(question);

                JSONArray answers = (JSONArray) question.get("answers");
                ArrayList<Answer> newAnswers = new ArrayList<>();
                for (int j = 0; j < answers.length(); j++) {
                    JSONObject answer = (JSONObject) answers.get(j);
                    Answer newAnswer = answerService.unpack(answer);
                    newAnswers.add(newAnswer);
                }
                newQuestion.setAnswers(newAnswers);
                questions.add(newQuestion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
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

}
