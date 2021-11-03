package nl.hsleiden.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import nl.hsleiden.controller.ResultController;
import nl.hsleiden.model.Content;
import nl.hsleiden.observer.ResultObserver;
import nl.hsleiden.subject.ResultSubject;

import java.io.IOException;

public class ResultView implements ResultObserver {

    private final ResultController resultController;
    @FXML
    private TextArea resultField;
    public Text adviesResultaat;
    public Button videoBtn;
    public Button afsluitBtn;
    public TextArea textAreaVerzonnen;
    private ActionEvent event;
    String fileName = "Result.fxml";

    public ResultView(){
        resultController = ResultController.getInstance();
    }

    @FXML
    protected void onVideoButtonClick() throws IOException {
        resultController.switchToNextScreen("Video.fxml");
    }

    @FXML
    protected void onExitButtonClick(){
        resultController.closeApplication();
    }


    public void sendContent(){
        resultController.sendContent();
        resultField.setText("hoi");
    }


    @Override
    public void update(ResultSubject state){


    }


}