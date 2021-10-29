package nl.hsleiden.service;

import nl.hsleiden.model.Answer;
import org.json.JSONObject;

public class AnswerService {

    public Answer unpack(JSONObject answer) {
        try {
            int id = (int) answer.get("id");
            String value = (String) answer.get("value");
            int currentContentId = (int) answer.get("currentContentId");
            int nextContentId = (int) answer.get("nextContentId");
            return new Answer(id, value, currentContentId, nextContentId);
        } catch (ClassCastException e) {
            return new Answer(0, null, 0, 0);
        }
    }
}
