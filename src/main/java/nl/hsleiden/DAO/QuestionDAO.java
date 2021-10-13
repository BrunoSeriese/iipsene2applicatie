package nl.hsleiden.DAO;

import nl.hsleiden.model.Question;

import java.util.ArrayList;

public class QuestionDAO implements DAO<Question> {
    private final String api = "http://localhost:8080/questions";

    @Override
    public ArrayList<Question> getAll() {
        return null;
    }

    @Override
    public Question get() {
        return null;
    }
}
