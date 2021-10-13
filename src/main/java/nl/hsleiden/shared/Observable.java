package nl.hsleiden.shared;

import nl.hsleiden.view.View;

public interface Observable {

    void registerObserver(View v);

    void unregisterObserver(View v);

    void notifyObserver();

}
