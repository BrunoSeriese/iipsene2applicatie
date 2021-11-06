package nl.hsleiden.model;

import java.util.ArrayList;
import java.util.Objects;

public  class Video implements Content {
    private final int id;
    private final String value;
    private final Answer answer;

    public Video(int id, String value, Answer answer) {
        this.id = id;
        this.value = value;
        this.answer = answer;
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

    public int id() {
        return id;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Video) obj;
        return this.id == that.id &&
                Objects.equals(this.value, that.value) &&
                Objects.equals(this.answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, answer);
    }

    @Override
    public String toString() {
        return "Video[" +
                "id=" + id + ", " +
                "value=" + value + ", " +
                "answer=" + answer + ']';
    }


}
