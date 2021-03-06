package nl.hsleiden.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.model.Content;
import nl.hsleiden.model.Explanation;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Contains methods for the views.
 * @author Hicham El Faquir, Ryan Bhola
 */
public class ExplanationView implements Initializable {

    @FXML
    public TextArea explanationText;

    public ExplanationView() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sendContent();
    }

    /**
     * Get the current content and set the explanation text for the current view
     * @author Hicham El Faquir, Ryan Bhola
     */
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
        if(nextContentId == 0 || !(content instanceof Explanation)) {
            nextContentId = 1;
        }
        ContentController.getInstance().nextContentId(nextContentId);
        ContentController.getInstance().nextContent();
    }
}
