package nl.hsleiden.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.controller.ResultController;
import nl.hsleiden.model.Content;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultView implements Initializable {

    private final ResultController resultController;
    public TextArea resultField;
    public Button resultButton;

    public ResultView() {
        resultController = ResultController.getInstance();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sendContent();
    }

    @FXML
    protected void onVideoButtonClick() {
        resultController.switchToNextScreen("Video.fxml");
    }

    @FXML
    protected void onExitButtonClick() {
        resultController.closeApplication();
    }

    @FXML
    public void sendContent() {
        Content content = ContentController.getInstance().getContent();
        resultField.setText(content.getValue());
    }
}