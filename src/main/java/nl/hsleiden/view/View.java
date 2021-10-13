package nl.hsleiden.view;

import nl.hsleiden.shared.Observable;

public interface View {

    void update(Observable model);
}