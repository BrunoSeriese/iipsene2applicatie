package nl.hsleiden.controller;

import nl.hsleiden.DAO.AnswerDAO;
import nl.hsleiden.service.AnswerService;

public class AnswerController {
    private static AnswerController answerController;
    private final AnswerService answerService;

    private AnswerController(){
        answerService = new AnswerService();
    }

    public synchronized static AnswerController getInstance() {
        if (answerController == null) {
            answerController = new AnswerController();
        }
        return answerController;
    }
}
