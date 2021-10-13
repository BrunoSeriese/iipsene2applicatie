package nl.hsleiden.controller;

import nl.hsleiden.view.View;

public class AnswerController implements Controller {

    static AnswerController answerController;

    public AnswerController(){

    }

    public static AnswerController getInstance() {
        if (answerController == null) {
            answerController = new AnswerController();
        }
        return answerController;
    }

    @Override
    public void registerObserver(View v) {

    }
}
