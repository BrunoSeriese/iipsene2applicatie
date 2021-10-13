package nl.hsleiden.controller;

import nl.hsleiden.DAO.ExplanationDAO;
import nl.hsleiden.service.ExplanationService;

public class ExplanationController {
    private static ExplanationController explanationController;
    private final ExplanationDAO explanationDAO;
    private final ExplanationService explanationService;

    public ExplanationController(ExplanationDAO explanationDAO,
                                 ExplanationService explanationService) {
        this.explanationDAO = explanationDAO;
        this.explanationService = explanationService;
    }

    public static ExplanationController getInstance() {
        if(explanationController == null) {
            explanationController = new ExplanationController(new ExplanationDAO(), new ExplanationService());
        }
        return explanationController;
    }
}
