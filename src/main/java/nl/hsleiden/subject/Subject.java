package nl.hsleiden.subject;

import nl.hsleiden.observer.Observer;

public interface Subject<T> {
    void registerObserver(Observer<T> observer);
    void unregisterObserver(Observer<T> observer);
    void notifyObservers();
}
