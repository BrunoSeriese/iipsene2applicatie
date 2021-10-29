package nl.hsleiden.service;

import nl.hsleiden.DAO.ExplanationDAO;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.model.Explanation;
import org.json.JSONObject;

import java.util.List;

public class ExplanationService {
    private final ExplanationDAO explanationDAO;
    private final ContentController contentController;

    public ExplanationService() {
        explanationDAO = new ExplanationDAO(this);
        contentController = ContentController.getInstance();
    }

    public Explanation unpack(JSONObject explanation) {
        int id = (int) explanation.get("id");
        String value = (String) explanation.get("value");
        return new Explanation(id, value);
    }

    public List<Explanation> getAll() {
        List<Explanation> explanations = this.explanationDAO.getAll();
        explanations.forEach(contentController::addContent);
        return explanations;
    }
}
