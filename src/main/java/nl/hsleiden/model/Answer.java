package nl.hsleiden.model;

import nl.hsleiden.observer.Observer;
import nl.hsleiden.subject.AnswerSubject;

import java.util.ArrayList;

public class Answer implements AnswerSubject {
    private final ArrayList<Observer<AnswerSubject>> observers = new ArrayList<>();

    private final int id;
    private final String value;
    private final int currentContentId;
    private final int nextContentId;

    public Answer(int id, String value, int currentContentId, int nextContentId) {
        this.id = id;
        this.value = value;
        this.currentContentId = currentContentId;
        this.nextContentId = nextContentId;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public int getCurrentContentId() {
        return currentContentId;
    }

    public int getNextContentId() {
        return nextContentId;
    }

    @Override
    public void registerObserver(Observer<AnswerSubject> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<AnswerSubject> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
