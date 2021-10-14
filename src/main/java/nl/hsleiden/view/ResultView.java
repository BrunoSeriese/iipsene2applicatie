package nl.hsleiden.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nl.hsleiden.controller.ResultController;
import nl.hsleiden.observer.ResultObserver;
import nl.hsleiden.subject.ResultSubject;

import java.io.IOException;

public class ResultView implements ResultObserver {

    private final ResultController resultController;

    public ResultView(){
        resultController = ResultController.getInstance();
    }

    @FXML
    protected void onVideoButtonClick(ActionEvent event) throws IOException {
        resultController.switchToNextScreen(event,"Video.fxml");
    }

    @FXML
    protected void onExitButtonClick(ActionEvent event){
        resultController.closeGame();
    }


    @Override
    public void update(ResultSubject state) {


    }
}