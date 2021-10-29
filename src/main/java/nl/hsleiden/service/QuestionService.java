package nl.hsleiden.service;

import nl.hsleiden.DAO.QuestionDAO;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.model.Question;
import org.json.JSONObject;

import java.util.List;

public class QuestionService {
    private final QuestionDAO questionDAO;
    private final ContentController contentController;

    public QuestionService() {
        questionDAO = new QuestionDAO(this);
        contentController = ContentController.getInstance();
    }

    public Question unpack(JSONObject question) {
        int id = (int) question.get("id");
        String value = (String) question.get("value");
        return new Question(id, value);
    }

    public List<Question> getAll() {
        List<Question> questions = this.questionDAO.getAll();
        questions.forEach(contentController::addContent);
        return questions;
    }
}
