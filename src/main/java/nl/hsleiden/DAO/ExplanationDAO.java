package nl.hsleiden.DAO;

import nl.hsleiden.model.Explanation;

import java.util.ArrayList;

public class ExplanationDAO implements DAO<Explanation> {
    private final String api = "http://localhost:8080/explanations";

    @Override
    public ArrayList<Explanation> getAll() {
        return null;
    }

    @Override
    public Explanation get() {
        return null;
    }
}
