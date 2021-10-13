package nl.hsleiden.controller;

import nl.hsleiden.DAO.QuestionDAO;

public class QuestionController {
    private static QuestionController questionController;
    private final QuestionDAO questionDAO;

    public QuestionController(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    public static QuestionController getInstance() {
        if(questionController == null) {
            questionController = new QuestionController(new QuestionDAO());
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
