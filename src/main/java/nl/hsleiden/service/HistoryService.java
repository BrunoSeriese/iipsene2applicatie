package nl.hsleiden.service;

import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HistoryService {
    private final static ArrayList<Map<Content, Answer>> history = new ArrayList<>();


    public HistoryService(){

    }

    public static void add(Content content, Answer answer) {
        Map<Content, Answer> hc = new HashMap<>();
        hc.put(content, answer);
        history.add(hc);
    }

    public static Map<Content, Answer> getLast() {
        return history.get(0);
    }
  public void remove(int id){

  }

  public ArrayList<Map<Content, Answer>> get(){
    return history;
  }

}
