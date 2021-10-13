package nl.hsleiden.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nl.hsleiden.controller.MainController;
import nl.hsleiden.observer.MainObserver;
import nl.hsleiden.subject.MainSubject;

import java.io.IOException;

public class MainView implements MainObserver {

    private final MainController mainController;

    public MainView(){
        mainController = MainController.getInstance();
    }

    @FXML
    protected void onNextButtonClick(ActionEvent event) throws IOException {
        mainController.switchToNextScreen(event,"Uitleg.fxml");
    }

    @Override
    public void update(MainSubject state) {

    }
}
