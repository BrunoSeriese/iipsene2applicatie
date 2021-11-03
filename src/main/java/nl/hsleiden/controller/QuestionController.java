package nl.hsleiden.controller;

import nl.hsleiden.model.Content;
import nl.hsleiden.service.HistoryService;
import nl.hsleiden.service.QuestionService;

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

    public  Content previousContent(){
        return contentController.previousContent();


    }
    public void setPreviousContent(int id){
        contentController.lastContentId(id);

    }
    public Content sendNextContent(){
        return contentController.nextContent();
    }

    public void setNextContentId(int id){
        contentController.nextContentId(id);
    }

    public void getQuestions() {
        questionService.getAll();
    }

}
