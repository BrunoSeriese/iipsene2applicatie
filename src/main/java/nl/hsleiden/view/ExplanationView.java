package nl.hsleiden.view;

import nl.hsleiden.controller.ExplanationController;
import nl.hsleiden.observer.ExplanationObserver;
import nl.hsleiden.subject.ExplanationSubject;

public class ExplanationView implements ExplanationObserver {

    private final ExplanationController explanationController;

    public ExplanationView() {
        explanationController = ExplanationController.getInstance();
    }

    @Override
    public void update(ExplanationSubject state) {

    }

    public void nextContent() {
        System.out.println("next content is coming!");
        explanationController.sendNextContent();
    }
}
