package nl.hsleiden.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.controller.QuestionController;
import nl.hsleiden.model.Content;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Contains methods for the views.
 * @author Hicham El Faquir, Ryan Bhola
 */
public class QuestionView implements Initializable {
    private final QuestionController questionController;

    @FXML
    public ToggleGroup group;
    @FXML
    public ArrayList<RadioButton> RadioButtons;
    @FXML
    public ArrayList<TextArea> Answers;
    @FXML
    public TextArea questionContainer;

    public QuestionView() {
        questionController = QuestionController.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        retrieveContent();
    }

    /**
     * Gets the content and prints the data on the screen.
     * @author Hicham El Faquir, Ryan Bhola
     */
    private void retrieveContent() {
        Content content = ContentController.getInstance().getContent();
        questionContainer.setText(content.getValue());

        for (int i = 0; i < content.getAnswer().size(); i++) {
            RadioButtons.get(i).setVisible(true);
            Answers.get(i).setText(content.getAnswer().get(i).getValue());
            Answers.get(i).setId(String.valueOf(content.getAnswer().get(i).getNextContentId()));
        }
    }

    /**
     * Detects which radiobutton was pressed and acts upon it.
     * @author Hicham El Faquir, Ryan Bhola
     */
    public void nextContent() {
        RadioButton chosenButton = (RadioButton) group.getSelectedToggle();
        for (int i = 0; i < RadioButtons.size(); i++) {
            if(chosenButton == RadioButtons.get(i)) {
                questionController.setNextContentId(Integer.parseInt(Answers.get(i).getId()));
            }
        }
        questionController.nextContent();
    }

    public void previousContent() {
        questionController.previousContent();
        retrieveContent();
    }

}
