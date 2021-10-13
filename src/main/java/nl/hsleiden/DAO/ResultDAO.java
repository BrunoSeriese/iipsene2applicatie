package nl.hsleiden.DAO;

import nl.hsleiden.model.Result;

import java.util.ArrayList;

public class ResultDAO implements DAO<Result> {
    private final String api = "http://localhost:8080/results";

    @Override
    public ArrayList<Result> getAll() {
        return null;
    }

    @Override
    public Result get() {
        return null;
    }
}
