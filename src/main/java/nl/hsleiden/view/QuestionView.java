package nl.hsleiden.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import nl.hsleiden.controller.QuestionController;
import nl.hsleiden.observer.QuestionObserver;
import nl.hsleiden.subject.QuestionSubject;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class QuestionView implements QuestionObserver {

    private final QuestionController questionController;
    @FXML
    public ToggleGroup group;
    @FXML
    public RadioButton Button1, Button2, Button3, Button4;
    @FXML
    private TextArea answer1, answer2, answer3, answer4;
    @FXML
    private TextArea questionContainer;
    public ArrayList<TextArea> answerList = new ArrayList<>();

    public QuestionView() {
        questionController = QuestionController.getInstance();
    }

    @Override
    public void update(QuestionSubject state) {

    }

    public void previousContent() {

    }


    public void nextContent() {
        questionController.sendNextContent();
        //        RadioButton chosenButton = (RadioButton) group.getSelectedToggle();
//        if (chosenButton == Button1){
//            questionController.setNextContentId(Integer.parseInt(answer1.getId()));
//        } else if (chosenButton == Button2){
//            questionController.setNextContentId(Integer.parseInt(answer2.getId()));
//        }else if (chosenButton == Button3){
//            questionController.setNextContentId(Integer.parseInt(answer3.getId()));
//        }else if (chosenButton == Button4){
//            questionController.setNextContentId(Integer.parseInt(answer4.getId()));
//        }
    }

}
