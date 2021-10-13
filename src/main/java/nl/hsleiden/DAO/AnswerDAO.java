package nl.hsleiden.DAO;

import nl.hsleiden.model.Answer;

import java.util.ArrayList;

public class AnswerDAO implements DAO<Answer> {
    private final String api = "http://localhost:8080/answers";

    @Override
    public ArrayList<Answer> getAll() {
        return null;
    }

    @Override
    public Answer get() {
        return null;
    }
}
