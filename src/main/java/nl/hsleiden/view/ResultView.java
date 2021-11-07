package nl.hsleiden.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.controller.ResultController;
import nl.hsleiden.model.Content;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Contains methods for the views.
 *
 * @author Hicham El Faquir, Ryan Bhola
 */
public class ResultView implements Initializable {
    private final ResultController resultController;
    @FXML
    private TextArea resultField;

    public ResultView() {
        resultController = ResultController.getInstance();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sendContent();
    }
}