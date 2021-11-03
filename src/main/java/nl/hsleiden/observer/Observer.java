package nl.hsleiden.observer;

public interface Observer<T> {
    void update(final T state);

}
