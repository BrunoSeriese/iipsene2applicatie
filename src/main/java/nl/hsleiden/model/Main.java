package nl.hsleiden.model;

import nl.hsleiden.shared.Observable;
import nl.hsleiden.view.View;

import java.util.ArrayList;
import java.util.List;

public class Main implements Observable {

    private List<View> observers = new ArrayList<View>();

    @Override
    public void registerObserver(View v) {
        this.observers.add(v);
    }

    @Override
    public void unregisterObserver(View v) {

    }

    @Override
    public void notifyObserver() {

    }
}
