package nl.hsleiden.controller;

import nl.hsleiden.DAO.ExplanationDAO;

public class ExplanationController {
    private static ExplanationController explanationController;
    private final ExplanationDAO explanationDAO;

    public ExplanationController(ExplanationDAO explanationDAO) {
        this.explanationDAO = explanationDAO;
    }

    public static ExplanationController getInstance() {
        if(explanationController == null) {
            explanationController = new ExplanationController(new ExplanationDAO());
        }
        return explanationController;
    }
}
