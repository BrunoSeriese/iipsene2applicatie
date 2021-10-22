package nl.hsleiden.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import nl.hsleiden.controller.QuestionController;
import nl.hsleiden.observer.QuestionObserver;
import nl.hsleiden.subject.QuestionSubject;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class QuestionView implements QuestionObserver, Initializable {

    private final QuestionController questionController;


    public QuestionView() {
        questionController = QuestionController.getInstance();
    }

    @FXML
    public RadioButton Button1, Button2, Button3, Button4;
    @FXML
    private TextArea answer1, answer2, answer3, answer4;
    @FXML
    private TextArea questionContainer;
    public ArrayList<TextArea> answerList = new ArrayList<>();


    @FXML
    public void onbtnclick() {
        System.out.println("HET WERKT");
    }

    @Override
    public void update(QuestionSubject state) {

    }

    public void previousContent() {
        System.out.println("previous content is coming");
        questionController.getPreviousContent();

        questionContainer.setText(questionController.unpackQuestions());
        for (int i = 0; i < 4; i++) {
            answerList.get(i).setText(questionController.unpackAnswers().get(i));
        }
    }


    public void nextContent() {
        System.out.println("next content is coming!");
        questionController.sendNextContent();
        questionContainer.setText(questionController.unpackQuestions());

        for (int i = 0; i < 4; i++) {
            answerList.get(i).setText(questionController.unpackAnswers().get(i));
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);
        answerList.add(answer4);

        questionContainer.setText(questionController.unpackQuestions());

        for (int i = 0; i < answerList.size(); i++) {
            answerList.get(i).setText(questionController.unpackAnswers().get(i));
        }
    }
}
