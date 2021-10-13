package nl.hsleiden.service;

import nl.hsleiden.model.Answer;
import nl.hsleiden.model.Content;

import java.util.ArrayList;
import java.util.Map;

public class HistoryService {
    private final ArrayList<Map<Content, Answer>> history = new ArrayList<>();


    public HistoryService(){

    }

  public void add(){

  }
  public void remove(int id){

  }

  public ArrayList<Map<Content, Answer>> get(){
    return history;
  }
}
