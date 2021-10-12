package nl.hsleiden.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea myText;


    @FXML
    protected void onHelloButtonClick() {
        myText.setEditable(false);
    }
}