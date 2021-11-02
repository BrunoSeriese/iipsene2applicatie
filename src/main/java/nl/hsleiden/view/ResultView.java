package nl.hsleiden.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import nl.hsleiden.controller.ResultController;
import nl.hsleiden.model.Content;
import nl.hsleiden.observer.ResultObserver;
import nl.hsleiden.subject.ResultSubject;

import java.io.IOException;

public class ResultView implements ResultObserver {

    private final ResultController resultController;
    public TextArea resultField;
    String fileName = "Result.fxml";
    public Button resultButton;

    public ResultView() {
        resultController = ResultController.getInstance();

    }

    @FXML
    protected void onVideoButtonClick(ActionEvent event) throws IOException {
        resultController.switchToNextScreen(event, "Video.fxml");
    }

    @FXML
    protected void onExitButtonClick() {
        resultController.closeApplication();
    }

    @FXML
    public void sendContent() {
        Content content = resultController.sendContent();
        resultField.setText(content.getValue());
    }

    @Override
    public void update(ResultSubject state) {


    }


}