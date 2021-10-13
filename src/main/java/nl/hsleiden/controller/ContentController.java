package nl.hsleiden.controller;

import nl.hsleiden.model.*;
import nl.hsleiden.service.HistoryService;

import java.util.Map;

public class ContentController {
    private static ContentController contentController;
    private final SceneController sceneController;
    public ContentController(){
        sceneController = SceneController.getInstance();
    }
    HistoryService historyService = new HistoryService();
    public static ContentController getInstance() {
        if (contentController == null) {
            contentController = new ContentController();
        }
        return contentController;
    }

    public void nextContent() {
        historyService.add(new Explanation(1,"checkme"), new Answer(1,"world", 1,1));
        Map<Content, Answer> historyContent = historyService.getLast();
        Content content = (Content) historyContent.keySet().toArray()[0];

        if ( content instanceof Question) {
            System.out.println("vraag");
        } else if (content instanceof Video) {
            System.out.println("video");
        } else if (content instanceof Result){
            System.out.println("resultaten");
        } else if (content instanceof Explanation){
            System.out.println("uitleg");
        }

    }


}
