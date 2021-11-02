package nl.hsleiden.service;

import javafx.stage.Stage;

public class StageService {
    private static StageService stageService;
    private Stage stage;

    private StageService() {

    }

    public synchronized static StageService getInstance() {
        if(stageService == null) {
            stageService = new StageService();
        }
        return stageService;
    }

    public synchronized static StageService getInstance(Stage stage) {
        if(stageService == null) {
            stageService = new StageService();
            stageService.setStage(stage);
        }
        return stageService;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
