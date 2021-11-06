package nl.hsleiden.model;

import java.util.ArrayList;

public class Explanation implements Content {

    private final int id;
    private final String value;
    private Answer answer;

    public Explanation(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public ArrayList<Answer> getAnswer() {
        ArrayList<Answer> answer = new ArrayList<>();
        answer.add(this.answer);
        return answer;
    }

}
