package nl.hsleiden.controller;

import nl.hsleiden.model.Content;
import nl.hsleiden.service.ContentService;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that controls anything/everything about/around the content.
 * Mainly controls what contents there are and which is the current content.
 * @author Vincent Severin, Hicham El Faquir, Ryan Bhola, Bruno Seriese
 */
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

    /**
     * Gets the needed contents and puts them in the contents list.
     * @author Bruno Seriese
     */
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
    /**
     * Gets the contentID of content called on.
     * @return the ID of the corresponding content, on which this method is called upon.
     * @author Bruno Seriese
     */
    public int getId(){
        return contentId;
    }

    /**
     * Goes to the next content based on the answer given by the user.
     * @author Vincent Severin, Bruno Seriese
     */
    public void nextContent() {
        Content content = getContentById(contentId);
        String filename = contentService.getFilename(content);
        sceneController.switchToNextScreen(filename);
    }

    /**
     * Goes to the previous content based on the answer given by the user.
     * @author Vincent Severin, Bruno Seriese
     */
    public void previousContent() {
        this.contentId = lastContentId;
        Content content = getContent();
        String filename = contentService.getFilename(content);
        sceneController.switchToNextScreen(filename);
    }

    /**
     * Sets the current content & sets the previous current content to last content.
     * @param id The new current content id
     * @author Bruno Seriese
     */
    public void nextContentId(int id) {
        lastContentId = contentId;
        this.contentId = id;
    }

    /**
     * Sets the last content.
     * @param id The new last content id
     * @author Bruno Seriese
     */
    public void lastContentId(int id) {
        this.lastContentId = id;
    }

    /**
     * Gets the current content using the getContentById() method.
     * @return The current content
     * @author Bruno Seriese
     */
    public Content getContent() {
        return getContentById(contentId);
    }

    /**
     * Gets the content by the same id as the param.
     * @param id The content id to find
     * @return The content with the same id as the param
     * @author Bruno Seriese, Ryan Bhola
     */
    public Content getContentById(int id) {
        for (Content content : contents) {
            if (content.getId() == id) {
                return content;
            }
        }
        return null;
    }
}
