package org.it.conference;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Conference {
    private List<Lecture> lectures;

    public void conference(){
        lectures = new ArrayList<>(9);
        LocalTime start1 = LocalTime.of(10,0);
        LocalTime end1 = LocalTime.of(11,45);
        LocalTime start2 = LocalTime.of(12,0);
        LocalTime end2 = LocalTime.of(13,45);
        LocalTime start3 = LocalTime.of(14,0);
        LocalTime end3 = LocalTime.of(15,45);

        this.addLecture(new Lecture(1L, "n1", "s1", start1, end1));
        this.addLecture(new Lecture(2L, "n2", "s2", start1, end1));
        this.addLecture(new Lecture(3L, "n3", "s3", start1, end1));
        this.addLecture(new Lecture(4L, "n4", "s1", start2, end2));
        this.addLecture(new Lecture(5L, "n5", "s2", start2, end2));
        this.addLecture(new Lecture(6L, "n6", "s3", start2, end2));
        this.addLecture(new Lecture(7L, "n7", "s1", start3, end3));
        this.addLecture(new Lecture(8L, "n8", "s2", start3, end3));
        this.addLecture(new Lecture(9L, "n9", "s3", start3, end3));
    }

    public String conferencePlan() {
        return lectures.toString();
    }

    void lecturesReport() {

    }

    void subjectsReport() {

    }

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }

}
