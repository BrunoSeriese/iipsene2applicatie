package nl.hsleiden.observer;

import javafx.scene.control.TextArea;

import java.io.IOException;

public interface Observer<T> {
    void update(final T state);

}
