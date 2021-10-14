package nl.hsleiden.view;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import nl.hsleiden.controller.ExplanationController;
import nl.hsleiden.controller.QuestionController;
import nl.hsleiden.observer.QuestionObserver;
import nl.hsleiden.subject.QuestionSubject;

import java.io.IOException;

public class QuestionView implements QuestionObserver {
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
    public void onbtnclick(){
        System.out.println("HET WERKT");
    }

    @Override
    public void update(QuestionSubject state) {

    }
    public void nextContent() throws IOException {
        System.out.println("next content is coming!");
        questionController.sendNextContent();
    }
}
