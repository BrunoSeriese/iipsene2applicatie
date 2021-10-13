package nl.hsleiden.controller;

import nl.hsleiden.DAO.ResultDAO;

public class ResultController {
    private static ResultController resultController;
    private final ResultDAO resultDAO;

    public ResultController(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    public static ResultController getInstance() {
        if(resultController == null) {
            resultController = new ResultController(new ResultDAO());
        }
        return resultController;
    }
}
