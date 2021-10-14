package nl.hsleiden.controller;

import nl.hsleiden.DAO.AnswerDAO;
import nl.hsleiden.service.AnswerService;

public class AnswerController {
    private static AnswerController answerController;
    private final AnswerDAO answerDAO;
    private final AnswerService answerService;

    private AnswerController(AnswerDAO answerDAO,
                            AnswerService answerService){
        this.answerDAO = answerDAO;
        this.answerService = answerService;
    }

    public synchronized static AnswerController getInstance() {
        if (answerController == null) {
            answerController = new AnswerController(new AnswerDAO(), new AnswerService());
        }
        return answerController;
    }
}
