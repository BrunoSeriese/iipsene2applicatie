package nl.hsleiden.controller;

public class QuestionController {
    private static QuestionController questionController;

    public QuestionController() {

    }

    public static QuestionController getInstance() {
        if(questionController == null) {
            questionController = new QuestionController();
        }
        return questionController;
    }
}
