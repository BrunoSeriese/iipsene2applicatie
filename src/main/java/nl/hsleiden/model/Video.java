package nl.hsleiden.model;

import nl.hsleiden.observer.Observer;
import nl.hsleiden.subject.VideoSubject;

import java.util.ArrayList;

public class Video implements Content, VideoSubject {
    private final ArrayList<Observer<VideoSubject>> observers = new ArrayList<>();

    private int id;
    private String value;
    private Answer answer;

    public Video(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public Video(int id, String value, Answer answer) {
        this.id = id;
        this.value = value;
        this.answer = answer;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public ArrayList<Answer> getAnswer() {
        ArrayList<Answer> answer = new ArrayList<>();
        answer.add(this.answer);
        return answer;
    }

    @Override
    public void registerObserver(Observer<VideoSubject> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<VideoSubject> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
