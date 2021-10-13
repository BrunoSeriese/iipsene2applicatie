package nl.hsleiden.model;

public class Result implements Content {
    private int id;
    private String value;
    private Answer answer;

    public Result(int id, String value) {

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
