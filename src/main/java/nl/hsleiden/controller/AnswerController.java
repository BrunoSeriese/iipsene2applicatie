package nl.hsleiden.controller;

public class AnswerController {
    private static AnswerController answerController;

    public AnswerController(){

    }

    public static AnswerController getInstance() {
        if (answerController == null) {
            answerController = new AnswerController();
        }
        return answerController;
    }
}
