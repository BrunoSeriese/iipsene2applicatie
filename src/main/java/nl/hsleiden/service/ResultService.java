package nl.hsleiden.service;

import nl.hsleiden.DAO.ResultDAO;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.model.Result;

import java.util.List;

public class ResultService {
    private final ResultDAO resultDAO;
    private final ContentController contentController;

    public ResultService() {
        resultDAO = new ResultDAO();
        contentController = ContentController.getInstance();
    }

    public List<Result> getAll() {
        List<Result> results = this.resultDAO.getAll();
        results.forEach(contentController::addContent);
        return results;
    }
}
