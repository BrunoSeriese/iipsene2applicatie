package nl.hsleiden.controller;

import nl.hsleiden.service.QuestionService;

public class QuestionController {
    private static QuestionController questionController;
    private final QuestionService questionService;
    private final ContentController contentController;

    private QuestionController() {
        questionService = new QuestionService();
        contentController = ContentController.getInstance();
    }

    public synchronized static QuestionController getInstance() {
        if(questionController == null) {
            questionController = new QuestionController();
        }
        return questionController;
    }

    public  void previousContent(){
        contentController.previousContent();
    }

    public void nextContent(){
        contentController.nextContent();
    }

    public void setNextContentId(int id){
        contentController.nextContentId(id);
    }

    public void getQuestions() {
        questionService.getAll();
    }

}
