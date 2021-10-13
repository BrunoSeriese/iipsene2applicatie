package nl.hsleiden.service;

import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HistoryService {
    private final ArrayList<Map<Content, Answer>> history = new ArrayList<>();

    public HistoryService(){

    }

    public void add(Content content, Answer answer) {
        Map<Content, Answer> history = new HashMap<>();
        history.put(content, answer);
        this.history.add(history);
    }

    public void remove(int id) {
        history.remove(id);
    }

    public void removeLast() {
        history.remove(history.size() - 1);
    }

    public Map<Content, Answer> get(int id) {
        return history.get(id);
    }

    public ArrayList<Map<Content, Answer>> getHistory() {
        return history;
    }

    public Map<Content, Answer> getLast() {
        return history.get(history.size() - 1);
    }
}
