package nl.hsleiden.controller;

import javafx.scene.control.TextArea;
import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Content;
import nl.hsleiden.service.HistoryService;

import java.io.IOException;
import java.util.ArrayList;

public class ContentController {
    private static ContentController contentController;
    private final HistoryService historyService;
    private final SceneController sceneController;
    private final ArrayList<Content> ourDatabase = new ArrayList<>();
    private int currentContentId = 1;


    private ContentController(HistoryService historyService) {
        this.historyService = historyService;
        sceneController = SceneController.getInstance();

    }


    public synchronized static ContentController getInstance() {
        if (contentController == null) {
            contentController = new ContentController(new HistoryService());
        }
        return contentController;
    }

    public void buildDatabase() throws IOException {
        QuestionController.getInstance().getQuestions();
        ResultController.getInstance().getResults();
    }



    public void unpackQuestion(TextArea textArea) {
        for (Content content : ourDatabase) {
            if (content.getId() == currentContentId) {
                setTextQuestion(textArea, content);
            }
        }
    }

    public void setTextQuestion(TextArea textArea, Content content){
        textArea.setText(content.getValue());
    }

    public void unpackAnswer(TextArea[] list) {
        for (Content content : ourDatabase) {
            if (content.getId() == currentContentId) {
                for (Answer answer : content.getAnswer()) {
                    for (TextArea ta: list) {
//                        ta.setText(answer.getValue());
                        System.out.println(ta.);
                    }
                }
            }
        }
    }





    public void addContent(Content content) {
        ourDatabase.add(content);
    }

    public void removeContent(Content content) {
        ourDatabase.remove(content);
    }

    public Content getContentById(int id) {
        for (Content content : ourDatabase) {
            if (content.getId() == id) {
                return content;
            }
        }
        return null;
    }

    public void nextContent() {
//        Pair<Content, Answer> historyContent = historyService.getLast();
//        int nextContentId = historyContent.getValue().getNextContentId();
//        Content content = getContentById(nextContentId);
//
//        if (content instanceof Question) {
//            System.out.println("vraag");
//            nextContentId();
////            sceneController.switchToNextScreen();
//        } else if (content instanceof Video) {
//            System.out.println("video");
////            sceneController.switchToNextScreen();
//        } else if (content instanceof Result) {
//            System.out.println("resultaten");
////            sceneController.switchToNextScreen();
//        } else if (content instanceof Explanation) {
//            System.out.println("uitleg");
////            sceneController.switchToNextScreen();
//        }
    }

    public void nextContentId() {
        this.currentContentId++;
    }

    public void previousContentId() {
        this.currentContentId--;
    }


}
