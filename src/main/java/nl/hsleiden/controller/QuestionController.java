package nl.hsleiden.controller;

import nl.hsleiden.DAO.QuestionDAO;
import nl.hsleiden.service.QuestionService;

public class QuestionController {
    private static QuestionController questionController;
    private final QuestionDAO questionDAO;
    private final QuestionService questionService;

    public QuestionController(QuestionDAO questionDAO,
                              QuestionService questionService) {
        this.questionDAO = questionDAO;
        this.questionService = questionService;
    }

    public static QuestionController getInstance() {
        if(questionController == null) {
            questionController = new QuestionController(new QuestionDAO(), new QuestionService());
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
