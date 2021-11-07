package nl.hsleiden.DAO;

import java.util.List;

/**
 * Tells what a DAO should at least contain.
 * @param <T> A Content
 * @author Vincent Severin
 */
public interface DAO<T> {
    List<T> getAll();
}
