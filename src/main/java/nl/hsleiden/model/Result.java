package nl.hsleiden.model;

import nl.hsleiden.observer.Observer;
import nl.hsleiden.observer.ResultObserver;
import nl.hsleiden.subject.ResultSubject;

import java.util.ArrayList;

public class Result implements Content, ResultSubject {
    private final ArrayList<Observer<ResultSubject>> observers = new ArrayList<>();

    private int id;
    private String value;
    private Answer answer;

    public Result(int id, String value, Answer answer) {
        this.id = id;
        this.value = value;
        this.answer = answer;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public Answer getAnswer() {
        return null;
    }

    @Override
    public void registerObserver(Observer<ResultSubject> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<ResultSubject> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
