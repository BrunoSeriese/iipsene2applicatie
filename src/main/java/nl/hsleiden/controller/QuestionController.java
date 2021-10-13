package nl.hsleiden.controller;

import nl.hsleiden.DAO.QuestionDAO;
import nl.hsleiden.service.QuestionService;

import nl.hsleiden.service.HistoryService;

public class QuestionController {
    private static QuestionController questionController;
    private static ContentController contentController;
    private final QuestionDAO questionDAO;
    private final QuestionService questionService;

    public QuestionController(QuestionDAO questionDAO,
                              QuestionService questionService) {
        this.questionDAO = questionDAO;
        this.questionService = questionService;
    }

    HistoryService historyService = new HistoryService();

    public static QuestionController getInstance() {
        if(questionController == null) {
            questionController = new QuestionController(new QuestionDAO(), new QuestionService());
        }
        return questionController;
    }

    public void getPreviousContent(){
        //TODO spreek met de historyService en haal de vorige content op



    }
    public void getNextContent(){
        //TODO spreek met de historyservice en geef de volgende content door
        contentController.nextContent();

    }
    public void showCurrentQuestion(){

    }
    public void showCurrentAnswer(){

    }
}
