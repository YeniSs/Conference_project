package org.it.conference;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {


    Optional<T> getUserId(long id);

    boolean updateByLogin(String login, String email, String newEmail);

    boolean booking(String login, String email, int lecture);

    Long userReservations(String login, int time);

    void removeReservation(String login, Long id);

    List<T> getAll();

    void notification(String line) throws FileNotFoundException, UnsupportedEncodingException;

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
