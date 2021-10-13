package nl.hsleiden.controller;

import nl.hsleiden.DAO.ResultDAO;
import nl.hsleiden.service.ResultService;

public class ResultController {
    private static ResultController resultController;
    private final ResultDAO resultDAO;
    private final ResultService resultService;

    public ResultController(ResultDAO resultDAO,
                            ResultService resultService) {
        this.resultDAO = resultDAO;
        this.resultService = resultService;
    }

    public static ResultController getInstance() {
        if(resultController == null) {
            resultController = new ResultController(new ResultDAO(), new ResultService());
        }
        return resultController;
    }
}
