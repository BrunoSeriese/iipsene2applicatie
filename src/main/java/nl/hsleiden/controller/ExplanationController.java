package nl.hsleiden.controller;

public class ExplanationController {
    private static ExplanationController explanationController;

    public ExplanationController() {

    }

    public static ExplanationController getInstance() {
        if(explanationController == null) {
            explanationController = new ExplanationController();
        }
        return explanationController;
    }
}
