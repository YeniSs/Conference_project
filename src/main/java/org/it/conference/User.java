package org.it.conference;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class User {
    private String login;
    private String email;
    private Long t1Reservation;
    private Long t2Reservation;
    private Long t3Reservation;

    public User(String login, String email, Long t1Reservation, Long t2Reservation, Long t3Reservation) {
        this.login = login;
        this.email = email;
        this.t1Reservation = t1Reservation;
        this.t2Reservation = t2Reservation;
        this.t3Reservation = t3Reservation;
    }

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public Long getT1Reservation() {
        return t1Reservation;
    }

    public void setT1Reservation(Long t1Reservation) {
        this.t1Reservation = t1Reservation;
    }

    public Long getT2Reservation() {
        return t2Reservation;
    }

    public void setT2Reservation(Long t2Reservation) {
        this.t2Reservation = t2Reservation;
    }

    public Long getT3Reservation() {
        return t3Reservation;
    }

    public void setT3Reservation(Long t3Reservation) {
        this.t3Reservation = t3Reservation;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("login", login)
                .append("email", email)
                .toString();
    }
}
