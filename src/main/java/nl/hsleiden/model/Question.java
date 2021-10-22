package nl.hsleiden.model;

import nl.hsleiden.observer.Observer;
import nl.hsleiden.subject.QuestionSubject;

import java.util.ArrayList;

public class Question implements Content, QuestionSubject {
    private final ArrayList<Observer<QuestionSubject>> observers = new ArrayList<>();

    private int id;
    private String value;
    private ArrayList<Answer> answers;

    public Question(int id, String value, ArrayList<Answer> answers ) {
        this.id = id;
        this.value = value;
        this.answers = answers;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public ArrayList<Answer> getAnswer() {
        return this.answers;
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
