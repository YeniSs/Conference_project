package org.it.conference;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalTime;

public class Lecture {
    private Long id;
    private String name;
    private String subject;
    private LocalTime startTime;
    private LocalTime endTime;
    private int seats = 5;

    public Lecture(Long id, String name, String subject, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("subject", subject)
                .append("startTime", startTime)
                .append("endTime", endTime)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
