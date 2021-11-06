package nl.hsleiden.service;

import nl.hsleiden.DAO.ExplanationDAO;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.model.Explanation;

import java.util.List;

public class ExplanationService {
    private final ExplanationDAO explanationDAO;
    private final ContentController contentController;

    public ExplanationService() {
        explanationDAO = new ExplanationDAO();
        contentController = ContentController.getInstance();
    }

    public List<Explanation> getAll() {
        List<Explanation> explanations = this.explanationDAO.getAll();
        explanations.forEach(contentController::addContent);
        return explanations;
    }
}
