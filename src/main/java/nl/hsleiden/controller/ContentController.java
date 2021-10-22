package nl.hsleiden.controller;

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


    public void unpackContent() {

        for (Content content : ourDatabase) {
            if (content.getId() == currentContentId) {
                System.out.println(content.getId());
                System.out.println(content.getValue());

                for (Answer answer : content.getAnswer()) {
                    System.out.println(answer.getValue());

                }
            }
        }
    }


    public int unpackIds() {
        int tmpId = 0;

        for (Content content : ourDatabase) {
            if (content.getId() == currentContentId) {
                tmpId = content.getId();
            }
        }
        System.out.println("AAAA  " + tmpId);
        return tmpId;
    }

    public String unpackQuestions() {
        String tmpQuestion = null;

        for (Content content : ourDatabase) {
            if (content.getId() == currentContentId) {
                tmpQuestion = content.getValue();
            }
        }
        return tmpQuestion;
    }

    public ArrayList<String> unpackAnswers() {
        String tmpAnswers;
        ArrayList<String> list = new ArrayList<>();

        for (Content content : ourDatabase) {
            if (content.getId() == currentContentId) {
                for (Answer answer : content.getAnswer()) {
                    tmpAnswers = answer.getValue();
                    list.add(tmpAnswers);
                }
            }
        }

        return list;
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
       //TODO unpackAnswers moet eigenlijk het aantal vragen zijn dus unpackQuestions, maar daar zitten nu resultaten is dus heb het zo moeten doen.
       if (this.currentContentId <= unpackAnswers().size()){
           this.currentContentId++;
       }
    }

    public void previousContentId() {
        if (this.currentContentId > 1) {
            this.currentContentId--;
        }
    }


}
