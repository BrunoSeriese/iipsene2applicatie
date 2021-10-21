package nl.hsleiden.model;

import nl.hsleiden.observer.Observer;
import nl.hsleiden.observer.QuestionObserver;
import nl.hsleiden.subject.QuestionSubject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Question implements Content, QuestionSubject {
    private final ArrayList<Observer<QuestionSubject>> observers = new ArrayList<>();

    private int id;
    private String value;
    private ArrayList<Answer> answers;

    public Question(int id, String value, ArrayList<Answer> answers ) {

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
    public void registerObserver(Observer<QuestionSubject> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<QuestionSubject> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
