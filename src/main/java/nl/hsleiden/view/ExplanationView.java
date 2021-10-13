package nl.hsleiden.view;

import nl.hsleiden.observer.ExplanationObserver;
import nl.hsleiden.subject.ExplanationSubject;

public class ExplanationView implements ExplanationObserver {
    @Override
    public void update(ExplanationSubject state) {

    }
    public void nextContent(){
        System.out.println("next content is coming!");
    }
}
