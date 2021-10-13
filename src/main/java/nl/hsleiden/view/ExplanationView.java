package nl.hsleiden.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nl.hsleiden.controller.ExplanationController;

import java.io.IOException;

public class ExplanationView {

    ExplanationController explanationController;

    public ExplanationView(){
        explanationController = ExplanationController.getInstance();
    }

    @FXML
    protected void onNextButtonClick(ActionEvent event) throws IOException {
        explanationController.switchToNextScreen(event,"Question.fxml");
    }
}
