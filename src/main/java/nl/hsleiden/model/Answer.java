package nl.hsleiden.model;

import java.util.Objects;

/**
 * Model for the answers.
 * @author Vincent Severin, Hicham El Faquir, Ryan Bhola, Bruno Seriese
 */
public class Answer {
    private final int id;
    private final String value;
    private final int nextContentId;

    public Answer(int id, String value, int nextContentId) {
        this.id = id;
        this.value = value;
        this.nextContentId = nextContentId;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public int getNextContentId() {
        return nextContentId;
    }

    public int id() {
        return id;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Answer) obj;
        return this.id == that.id &&
                Objects.equals(this.value, that.value) &&
                this.nextContentId == that.nextContentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, nextContentId);
    }

    @Override
    public String toString() {
        return "Answer[" +
                "id=" + id + ", " +
                "value=" + value + ", " +
                "nextContentId=" + nextContentId + ']';
    }

}
