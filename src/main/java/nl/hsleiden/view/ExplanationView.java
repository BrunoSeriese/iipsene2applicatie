package nl.hsleiden.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nl.hsleiden.controller.ExplanationController;
import nl.hsleiden.observer.ExplanationObserver;
import nl.hsleiden.subject.ExplanationSubject;

import java.io.IOException;

public class ExplanationView implements ExplanationObserver {

    private final ExplanationController explanationController;

    public ExplanationView() {
        explanationController = ExplanationController.getInstance();
    }

    @Override
    public void update(ExplanationSubject state) {

    }

    public void nextContent() {
        System.out.println("next content is coming!");
        explanationController.sendNextContent();
    }

    @FXML
    protected void onNextButtonClick(ActionEvent event) throws IOException {
        explanationController.switchToNextScreen(event,"Question.fxml");
    }
}
