package nl.hsleiden.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public  class Question implements Content, Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    private final int id;
    private final String value;
    private final ArrayList<Answer> answers;

    public Question(int id, String value,
                    ArrayList<Answer> answers) {
        this.id = id;
        this.value = value;
        this.answers = answers;
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

    public int id() {
        return id;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Question) obj;
        return this.id == that.id &&
                Objects.equals(this.value, that.value) &&
                Objects.equals(this.answers, that.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, answers);
    }

    @Override
    public String toString() {
        return "Question[" +
                "id=" + id + ", " +
                "value=" + value + ", " +
                "answers=" + answers + ']';
    }


}
