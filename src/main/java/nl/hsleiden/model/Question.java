package nl.hsleiden.model;

public class Question implements Content {
    private int id;
    private String value;
    private Answer[] answers;

    public Question(int id, String value) {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public Answer getAnswer() {
        return null;
    }

}
