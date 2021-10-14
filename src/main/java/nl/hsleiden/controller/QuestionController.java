package nl.hsleiden.controller;

import nl.hsleiden.DAO.QuestionDAO;
import nl.hsleiden.service.QuestionService;

import nl.hsleiden.service.HistoryService;

public class QuestionController {
    private static QuestionController questionController;
    private final QuestionDAO questionDAO;
    private final QuestionService questionService;
    private final SceneController sceneController;
    private final ContentController contentController;


    public QuestionController(QuestionDAO questionDAO,
                              QuestionService questionService) {
        this.questionDAO = questionDAO;
        this.questionService = questionService;
        sceneController = SceneController.getInstance();
        contentController = ContentController.getInstance();
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

    public void sendNextContent() {

        System.out.println("this works!");
        contentController.nextContent();
    }
    public void showCurrentQuestion(){

    }
    public void showCurrentAnswer(){

    }
}
