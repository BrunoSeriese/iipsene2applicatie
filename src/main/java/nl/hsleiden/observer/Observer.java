package nl.hsleiden.observer;

import javafx.scene.control.TextArea;

public interface Observer<T> {
    void update(final T state);

}
