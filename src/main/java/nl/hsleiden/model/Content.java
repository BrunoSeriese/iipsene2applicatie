package nl.hsleiden.model;

import java.util.ArrayList;

/**
 * Tells what a content should contain.
 * @author Vincent Severin
 */
public interface Content {
    int getId();
    String getValue();
    ArrayList<Answer> getAnswer();

}
