package nl.hsleiden.controller;

import nl.hsleiden.model.*;
import nl.hsleiden.service.HistoryService;

import java.util.Map;

public class ContentController {

    HistoryService historyService = new HistoryService();


    public void nextContent() {
        Map<Content, Answer> historyContent = historyService.getLast();
        Content content = (Content) historyContent.keySet().toArray()[0];

        if ( content instanceof Question) {
            System.out.println("resultaten");
        } else if (content instanceof Video) {
            System.out.println("resultaten");
        } else if (content instanceof Result){
            System.out.println("resultaten");
        }

    }


}
