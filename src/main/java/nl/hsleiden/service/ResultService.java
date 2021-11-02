package nl.hsleiden.service;

import nl.hsleiden.DAO.ResultDAO;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.model.Result;
import org.json.JSONObject;

import java.util.List;

public class ResultService {
    private final ResultDAO resultDAO;
    private final ContentController contentController;

    public ResultService() {
        resultDAO = new ResultDAO(this);
        contentController = ContentController.getInstance();
    }

    public Result unpack(JSONObject result) {
        int id = (int) result.get("id");
        String value = (String) result.get("value");
        return new Result(id, value);
    }

    public List<Result> getAll() {
        List<Result> results = this.resultDAO.getAll();
        results.forEach(contentController::addContent);
        return results;
    }
}
