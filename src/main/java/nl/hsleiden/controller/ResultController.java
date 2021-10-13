package nl.hsleiden.controller;

public class ResultController {
    private static ResultController resultController;

    public ResultController() {

    }

    public static ResultController getInstance() {
        if(resultController == null) {
            resultController = new ResultController();
        }
        return resultController;
    }
}
