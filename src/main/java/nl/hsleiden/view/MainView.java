package nl.hsleiden.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nl.hsleiden.controller.MainController;
import nl.hsleiden.shared.Observable;
import nl.hsleiden.shared.Observer;

import java.io.IOException;

public class MainView implements View, Observer {

    MainController mainController;

    public MainView(){
        mainController = MainController.getInstance();
        mainController.registerObserver(this);
    }

    @FXML
    protected void onNextButtonClick(ActionEvent event) throws IOException {
        mainController.switchToNextScreen(event,"Uitleg.fxml");
    }

    @Override
    public void update(Observable model) {

    }
}
