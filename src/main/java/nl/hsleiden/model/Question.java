package nl.hsleiden.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Content, Serializable {

    private final int id;
    private final String value;
    private ArrayList<Answer> answers;

    public Question(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public ArrayList<Answer> getAnswer() {
        return this.answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
}
