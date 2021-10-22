package nl.hsleiden.controller;

import nl.hsleiden.DAO.NetworkDAO;
import nl.hsleiden.DAO.QuestionDAO;
import nl.hsleiden.service.HistoryService;
import nl.hsleiden.service.QuestionService;

import java.io.IOException;

public class QuestionController {
    private static QuestionController questionController;
    private final QuestionDAO questionDAO;
    private final QuestionService questionService;
    private final SceneController sceneController;
    private final ContentController contentController;
    private final NetworkDAO networkDAO;
    private final HistoryService historyService = new HistoryService();

    private QuestionController(QuestionDAO questionDAO, QuestionService questionService) {
        this.questionDAO = questionDAO;
        this.questionService = questionService;
        sceneController = SceneController.getInstance();
        contentController = ContentController.getInstance();
        networkDAO = NetworkDAO.getInstance();
    }

    public synchronized static QuestionController getInstance() {
        if (questionController == null) {
            questionController = new QuestionController(new QuestionDAO(), new QuestionService());
        }
        return questionController;
    }

    public void getPreviousContent() {
        //TODO spreek met de historyService en haal de vorige content op

    }

    public void sendNextContent() {
        System.out.println("this works!");
        contentController.nextContent();
        contentController.unpackContent();
        contentController.nextContentId();
    }

    public void getQuestions() {
        questionDAO.getQuestions();
    }




}
