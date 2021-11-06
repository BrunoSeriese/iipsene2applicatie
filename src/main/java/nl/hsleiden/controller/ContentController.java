package nl.hsleiden.controller;

import nl.hsleiden.model.Content;
import nl.hsleiden.service.ContentService;

import java.util.ArrayList;
import java.util.List;

public class ContentController {
    private static ContentController contentController;
    private final ContentService contentService;
    private final SceneController sceneController;
    private final List<Content> contents = new ArrayList<>();
    private int contentId = 1;
    private int lastContentId = 1;

    private ContentController() {
        contentService = new ContentService();
        sceneController = SceneController.getInstance();
    }

    public synchronized static ContentController getInstance() {
        if (contentController == null) {
            contentController = new ContentController();
        }
        return contentController;
    }

    public void buildDatabase() {
        QuestionController.getInstance().getQuestions();
        ResultController.getInstance().getResults();
    }

    public void addContent(Content content) {
        contents.add(content);
    }

    public void removeContent(Content content) {
        contents.remove(content);
    }

    public int getId(){
        return contentId;
    }

    public void nextContent() {
        Content content = getContentById(contentId);
        String filename = contentService.getFilename(content);
        sceneController.switchToNextScreen(filename);
    }

    public void previousContent() {
        this.contentId = lastContentId;
        Content content = getContent();
        String filename = contentService.getFilename(content);
        sceneController.switchToNextScreen(filename);
    }

    public void nextContentId(int id) {
        this.contentId = id;
    }

    public void lastContentId(int id) {
        this.lastContentId = id;
    }

    public Content getContent() {
        return getContentById(contentId);
    }

    public Content getContentById(int id) {
        for (Content content : contents) {
            if (content.getId() == id) {
                return content;
            }
        }
        return null;
    }
}
