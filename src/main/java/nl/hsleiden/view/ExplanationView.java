package nl.hsleiden.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import nl.hsleiden.controller.ExplanationController;

import java.net.URL;
import java.util.ResourceBundle;

public class ExplanationView implements Initializable {

    private final ExplanationController explanationController;


    public ExplanationView() {
        explanationController = ExplanationController.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void nextContent() {


    }

    @FXML
    protected void onNextButtonClick(ActionEvent actionEvent) {
        explanationController.switchToNextScreen("Question.fxml");
    }
}
