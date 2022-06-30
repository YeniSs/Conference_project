package org.it.conference;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static Dao<User> userDao;


    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        userDao = new UserDao();
        var conference = new Conference();
        conference.conference();
        Scanner sc = new Scanner(System.in);
        String login;
        String email;
        int choice;
        long choice2;
        userDao.booking("testuser1","test@user1.com",1);
        conference.removeSeat(1);
        userDao.booking("testuser1","test@user1.com",5);
        conference.removeSeat(5);
        userDao.booking("testuser1","test@user1.com", 8);
        conference.removeSeat(8);
        userDao.booking("testuser2","test@user2.com",3);
        conference.removeSeat(3);
        userDao.booking("testuser2","test@user2.com",5);
        conference.removeSeat(5);
        userDao.booking("testuser2","test@user2.com", 9);
        conference.removeSeat(9);
        boolean var = true;

        do {
            /*+
                    "[7] Statystyki dla organizatora\n"*/
            System.out.println("""
                    [1] Plan konferencji
                    [2] Moje prelekcje
                    [3] Zapisy na prelekcje
                    [4] Anulowanie rezerwacji
                    [5] Aktualizacja adresu e-mail
                    [6] Lista zarejestrowanych użytkowników
                    [8] Wyłącz program""");


            System.out.println("Wybór:");
            switch (sc.nextInt()) {
                case 1 -> System.out.println(conference.conferencePlan());
                case 2 -> {
                    System.out.println("Podaj login:");
                    sc.nextLine();
                    login = sc.nextLine();
                    System.out.println(conference.singleLecture(userDao.userReservations(login, 1)));
                    System.out.println(conference.singleLecture(userDao.userReservations(login, 2)));
                    System.out.println(conference.singleLecture(userDao.userReservations(login, 3)));
                }
                case 3 -> {
                    if (conference.lecturesPlan()) {
                        System.out.println("Wybierz prelekcje:");
                        choice = sc.nextInt();
                        System.out.println("Podaj login:");
                        sc.nextLine();
                        login = sc.nextLine();
                        System.out.println("Podaj email:");
                        email = sc.nextLine();
                        if (userDao.booking(login, email, choice)) {
                            conference.removeSeat(choice);
                            userDao.notification("Cześć " + login + "! Potwierdzamy rezerwację prelekcji " + conference.singleLecture((long) choice));
                        }
                    } else {
                        System.out.println("Brak wolnych miejsc");
                    }
                    conference.lecturesPlan();
                }
                case 4 -> {
                    System.out.println("Podaj login:");
                    sc.nextLine();
                    login = sc.nextLine();
                    System.out.println(conference.singleLecture(userDao.userReservations(login, 1)));
                    System.out.println(conference.singleLecture(userDao.userReservations(login, 2)));
                    System.out.println(conference.singleLecture(userDao.userReservations(login, 3)));
                    System.out.println("Wybierz numer prelekcji do anulowania:");
                    choice2 = sc.nextLong();
                    userDao.removeReservation(login, choice2);
                    conference.addSeat(Math.toIntExact(choice2));
                    System.out.println("Pozostałe rezerwacje");
                    System.out.println(conference.singleLecture(userDao.userReservations(login, 1)));
                    System.out.println(conference.singleLecture(userDao.userReservations(login, 2)));
                    System.out.println(conference.singleLecture(userDao.userReservations(login, 3)));
                }
                case 5 -> {
                    System.out.println("Podaj login:");
                    sc.nextLine();
                    login = sc.nextLine();
                    System.out.println("Podaj aktualny email:");
                    String prevEmail = sc.nextLine();
                    System.out.println("Podaj nowy email:");
                    email = sc.nextLine();
                    userDao.updateByLogin(login, prevEmail, email);
                }
                case 6 -> userDao.getAll().forEach(user -> System.out.println(user.getLogin() + " " + user.getEmail()));

//                case 7:
//                    break;
                case 8 -> var = false;
            }
            System.out.println("\n\n");

        } while (var);

    }

}