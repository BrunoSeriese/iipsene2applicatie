package nl.hsleiden.controller;

import nl.hsleiden.DAO.AnswerDAO;

public class AnswerController {
    private static AnswerController answerController;
    private final AnswerDAO answerDAO;

    public AnswerController(AnswerDAO answerDAO){
        this.answerDAO = answerDAO;
    }

    public static AnswerController getInstance() {
        if (answerController == null) {
            answerController = new AnswerController(new AnswerDAO());
        }
        return answerController;
    }
}
