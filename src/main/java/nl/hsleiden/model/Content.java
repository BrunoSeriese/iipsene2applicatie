package nl.hsleiden.model;

import java.util.ArrayList;

public interface Content {
    int getId();
    String getValue();
    ArrayList<Answer> getAnswer();

}
