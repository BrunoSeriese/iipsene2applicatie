package nl.hsleiden.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nl.hsleiden.controller.MainController;

public class MainView {

    private final MainController mainController;

    public MainView(){
        mainController = MainController.getInstance();
    }

    @FXML
    protected void onNextButtonClick(ActionEvent actionEvent) {
        mainController.switchToNextScreen("Explanation.fxml");
    }

}
