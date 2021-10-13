package nl.hsleiden.DAO;

import java.util.ArrayList;

public interface DAO<T> {
    ArrayList<T> getAll();
    T get();
}
