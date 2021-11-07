package nl.hsleiden.view;

import javafx.fxml.FXML;
import nl.hsleiden.controller.MainController;

/**
 * Contains methods for the views.
 * @author Hicham El Faquir, Ryan Bhola
 */
public class MainView {

    private final MainController mainController;

    public MainView(){
        mainController = MainController.getInstance();
    }

    @FXML
    protected void onNextButtonClick() {
        mainController.switchToNextScreen("Explanation.fxml");
    }

}
