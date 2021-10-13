package nl.hsleiden.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nl.hsleiden.controller.MainController;

import java.io.IOException;

public class MainView {

    MainController mainController;

    public MainView(){
        mainController = MainController.getInstance();
    }

    @FXML
    protected void onNextButtonClick(ActionEvent event) throws IOException {
        mainController.switchToNextScreen(event,"Uitleg.fxml");
    }

}
