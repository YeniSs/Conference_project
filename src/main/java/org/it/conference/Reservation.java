package org.it.conference;

public class Reservation {
    private Long userID;
    private Long lectureID;

    public Reservation(Long userID, Long lectureID) {
        this.userID = userID;
        this.lectureID = lectureID;
    }
}
