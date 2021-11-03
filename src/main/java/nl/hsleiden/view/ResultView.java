package nl.hsleiden.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import nl.hsleiden.controller.ResultController;
import nl.hsleiden.model.Content;
import nl.hsleiden.observer.ResultObserver;
import nl.hsleiden.subject.ResultSubject;

import java.io.IOException;
import java.lang.annotation.Inherited;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultView implements ResultObserver, Initializable {

    private final ResultController resultController;
    public TextArea resultField;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sendContent();
    }
}