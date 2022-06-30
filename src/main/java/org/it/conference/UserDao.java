package org.it.conference;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserDao implements Dao<User> {

    private List<User> users = new ArrayList<>();

    public UserDao() {
        users.add(new User("root", "root@root.com"));
        users.add(new User("testuser1", "test@user1.com"));
        users.add(new User("testuser2", "test@user2.com"));
    }

    @Override
    public Optional<User> getUserId(long id) {
        return Optional.ofNullable(users.get((int) id));
    }

    @Override
    public boolean updateByLogin(String login, String email, String newEmail) {
        for (User el : users) {
            if (Objects.equals(el.getLogin(), login) && Objects.equals(el.getEmail(), email)) {
                el.setEmail(newEmail);
                System.out.println("Email został zaktualizowany");
                return true;
            }
        }
        System.out.println("Email nie został zaktualizowany, sprawdź poprawność danych");
        return false;
    }

    @Override
    public boolean booking(String login, String email, int lectureId) {
        for (User el : users) {
            if (Objects.equals(el.getLogin(), login)) {
                if (!Objects.equals(el.getEmail(), email)) {
                    System.out.println("Podany login jest już zajęty");
                    return false;
                }
                if ((lectureId >= 1 && lectureId <= 3 && el.getT1Reservation() != null) ||
                        (lectureId >= 4 && lectureId <= 6 && el.getT2Reservation() != null) ||
                        (lectureId >= 7 && lectureId <= 9 && el.getT3Reservation() != null)) {
                    System.out.println("W tych godzinach jest już zarezerwowana prelekcja dla tego konta");
                    return false;
                }
                if (lectureId >= 1 && lectureId <= 3) {
                    el.setT1Reservation((long) lectureId);
                } else if (lectureId >= 4 && lectureId <= 6) {
                    el.setT2Reservation((long) lectureId);
                } else if (lectureId >= 7 && lectureId <= 9) {
                    el.setT3Reservation((long) lectureId);
                }
                System.out.println("Zarezerwowano prelekcje o numerze id " + lectureId);
                return true;
            }
        }
        return false;
    }


    @Override
    public Long userReservations(String login, int time) {
        for (User el : users) {
            if (Objects.equals(el.getLogin(), login)) {
                if (time == 1) {
                    return el.getT1Reservation();
                } else if (time == 2) {
                    return el.getT2Reservation();
                } else if (time == 3) {
                    return el.getT3Reservation();
                }
            }
        }
        return null;
    }

    @Override
    public void removeReservation(String login, Long id) {
        for (User el : users) {
            if (Objects.equals(el.getLogin(), login)) {
                if (id >= 1 && id <= 3 && Objects.equals(el.getT1Reservation(), id)) {
                    el.setT1Reservation(null);
                    System.out.println("Rezerwacja o numerze id " + id + " została anulowana");
                    break;
                } else if (id >= 4 && id <= 6 && Objects.equals(el.getT2Reservation(), id)) {
                    el.setT2Reservation(null);
                    System.out.println("Rezerwacja o numerze id " + id + " została anulowana");
                    break;
                } else if (id >= 7 && id <= 9 && Objects.equals(el.getT3Reservation(), id)) {
                    el.setT3Reservation(null);
                    System.out.println("Rezerwacja o numerze id " + id + " została anulowana");
                    break;
                } else {
                    System.out.println("Podano niepoprawny numer");

                }
            }
        }
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    public void notification(String line) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter("powiadomienia.txt", "UTF-8");
        writer.println(line);
        writer.close();

    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void update(User user, String[] params) {
        user.setLogin(Objects.requireNonNull(
                params[0], "Login cannot be null"));
        user.setEmail(Objects.requireNonNull(
                params[1], "Email cannot be null"));
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}