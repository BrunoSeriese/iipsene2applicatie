package nl.hsleiden.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.controller.ExplanationController;
import nl.hsleiden.model.Content;
import nl.hsleiden.model.Explanation;

import java.net.URL;
import java.util.ResourceBundle;

public class ExplanationView implements Initializable {

    private final ExplanationController explanationController;

    @FXML
    public TextArea explanationText;

    public ExplanationView() {
        explanationController = ExplanationController.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sendContent();
    }

    @FXML
    public void sendContent() {
        Content content = ContentController.getInstance().getContent();
        String text = content.getValue();
        if(content.getAnswer().get(0).getNextContentId() != 0 && content instanceof Explanation) {
            explanationText.setText(text);
        }
    }

    @FXML
    public void onNextButtonClick() {
        Content content = ContentController.getInstance().getContent();
        int nextContentId = content.getAnswer().get(0).getNextContentId();
        if(nextContentId == 0) {
            nextContentId = 1;
        }
        ContentController.getInstance().nextContentId(nextContentId);
        ContentController.getInstance().nextContent();
    }
}
