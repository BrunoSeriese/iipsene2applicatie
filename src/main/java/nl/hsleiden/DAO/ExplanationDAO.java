package nl.hsleiden.DAO;

import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Explanation;
import nl.hsleiden.model.Video;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ExplanationDAO implements DAO<Explanation> {

    public ExplanationDAO() {

    }

    @Override
    public List<Explanation> getAll() {
        return null;
    }

    @Override
    public Explanation get(Long id) {
        return null;
    }

    @Override
    public Explanation create(Explanation explanation) {
        return null;
    }

    @Override
    public Explanation update(Long id) {
        return null;
    }

    @Override
    public void delete(Explanation explanation) {

    }

    public void getExplanations() throws IOException {
        JSONArray json = new JSONArray(IOUtils.toString(new URL("http://localhost:8080/explanations"), StandardCharsets.UTF_8));

        for (int i = 0; i < json.length(); i++) {
            JSONObject explanations = (JSONObject) json.get(i);
            int eid = (int) explanations.get("id");
            String evalue = (String) explanations.get("value");

            JSONObject answer = (JSONObject) explanations.get("answer");
            int aid = (int) answer.get("id");
            String avalue = (String) answer.get("value");
            int acurrentContentId = (int) answer.get("currentContentId");
            int anextContentId = (int) answer.get("nextContentId");

            Answer newAnswer = new Answer(aid, avalue, acurrentContentId, anextContentId);

            Explanation newExplanation = new Explanation(eid, evalue, newAnswer);
        }
    }
}
