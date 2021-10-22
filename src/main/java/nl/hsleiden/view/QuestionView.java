package nl.hsleiden.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import nl.hsleiden.controller.QuestionController;
import nl.hsleiden.observer.QuestionObserver;
import nl.hsleiden.subject.QuestionSubject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuestionView implements QuestionObserver, Initializable {

    private final QuestionController questionController;


    public QuestionView() {
        questionController = QuestionController.getInstance();
    }

    @FXML
    RadioButton Button1;
    @FXML
    RadioButton Button2;
    @FXML
    RadioButton Button3;
    @FXML
    RadioButton Button4;

    @FXML
    private TextArea answer1, answer2, answer3, answer4;
    @FXML
    private TextArea questionContainer;

    public TextArea[] answerList;




    @Override
    public void update(QuestionSubject state) {

    }

    public void nextContent() {
        questionController.sendNextContent(answerList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        answerList = new TextArea[]{
                answer1, answer2, answer3, answer4
        };
        questionController.sendNextContent(answerList);
    }
}
