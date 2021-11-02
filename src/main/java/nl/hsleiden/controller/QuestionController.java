package nl.hsleiden.controller;

import nl.hsleiden.DAO.AnswerDAO;
import nl.hsleiden.DAO.NetworkDAO;
import nl.hsleiden.DAO.QuestionDAO;
import nl.hsleiden.service.HistoryService;
import nl.hsleiden.service.QuestionService;

import java.util.ArrayList;

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
            questionController = new QuestionController(new QuestionDAO(getInstance().questionService), new QuestionService());
        }
        return questionController;
    }

    public void getPreviousContent() {
        //TODO spreek met de historyService en haal de vorige content op
        contentController.previousContentId();
    }

    public void sendNextContent() {
//        contentController.nextContent();
//        contentController.nextContentId();
    }


    public String unpackQuestions() {
        return contentController.unpackQuestions();
    }

    public ArrayList<String> unpackAnswers() {
        return contentController.unpackAnswers();
    }

    public ArrayList<Integer> unpackAnswersId() {
        return contentController.unpackAnswersId();
    }


    public void getQuestions() {
        questionDAO.getAll();
    }


    public void setNextContentId(int id) {
        contentController.nextContentId(id);
    }
}
