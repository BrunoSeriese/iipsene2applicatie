package nl.hsleiden.model;

import nl.hsleiden.observer.Observer;
import nl.hsleiden.subject.ExplanationSubject;

import java.util.ArrayList;

public class Explanation implements Content, ExplanationSubject {
    private final ArrayList<Observer<ExplanationSubject>> observers = new ArrayList<>();

    private int id;
    private String value;
    private Answer answer;

    public Explanation(int id, String value, Answer answer) {
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
        return null;
    }

    @Override
    public Answer getAnswer() {
        return null;
    }

    @Override
    public void registerObserver(Observer<ExplanationSubject> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<ExplanationSubject> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }

}
