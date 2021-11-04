package nl.hsleiden.model;

import java.util.ArrayList;

public class Result implements Content {

    private final int id;
    private final String value;
    private Answer answer;

    public Result(int id, String value) {
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
        ArrayList<Answer> answer = new ArrayList<>();
        answer.add(this.answer);
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
