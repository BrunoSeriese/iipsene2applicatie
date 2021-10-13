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

    public void getPreviousQuestion(){
        //TODO spreek met de historyService en haal het gegeven antwoord weg
    }
    public void getNextQuestion(){
        //TODO spreek met de historyservice en geef het antwoord door
    }
}
