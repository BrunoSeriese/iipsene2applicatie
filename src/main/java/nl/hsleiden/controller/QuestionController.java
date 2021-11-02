package nl.hsleiden.controller;

import nl.hsleiden.DAO.NetworkDAO;
import nl.hsleiden.DAO.QuestionDAO;
import nl.hsleiden.service.QuestionService;

import nl.hsleiden.service.HistoryService;

import java.io.IOException;

public class QuestionController {
    private static QuestionController questionController;
    private final QuestionService questionService;
    private final SceneController sceneController;
    private final ContentController contentController;
    private final HistoryService historyService = new HistoryService();

    private QuestionController() {
        questionService = new QuestionService();
        sceneController = SceneController.getInstance();
        contentController = ContentController.getInstance();
    }

    public synchronized static QuestionController getInstance() {
        if(questionController == null) {
            questionController = new QuestionController();
        }
        return questionController;
    }

    public void getPreviousContent(){
        //TODO spreek met de historyService en haal de vorige content op


    }

    public void sendNextContent() {
        contentController.nextContent();
    }

    public void getQuestions() {
        questionService.getAll();
    }

}
