package org.it.conference;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Conference {
    private List<Lecture> lectures;

    public void conference() {
        lectures = new ArrayList<>(9);
        LocalTime start1 = LocalTime.of(10, 0);
        LocalTime end1 = LocalTime.of(11, 45);
        LocalTime start2 = LocalTime.of(12, 0);
        LocalTime end2 = LocalTime.of(13, 45);
        LocalTime start3 = LocalTime.of(14, 0);
        LocalTime end3 = LocalTime.of(15, 45);

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
        return """
                **Plan konferencji**

                Konferencja trwa 1 dzień: 1 czerwca 2021.
                Rozpoczyna się o godzinie 10:00 a kończy o godzinie 15:45.
                Każda prelekcja trwa 1h 45m (15 minut to przerwa na kawę):
                - pierwsza prelekcja rozpoczyna się o 10:00 i trwa do 11:45.
                - druga prelekcja rozpoczyna się o 12:00 i kończy o 13:45.
                - trzecia prelekcja rozpoczyna się o 14:00 i kończy o 15:45

                Dostępne ścieżki tematyczne:
                - ścieżka tematyczna a
                - ścieżka tematyczna b
                - ścieżka tematyczna c

                Można uczestniczyć tylko w jednej ścieżce tematycznej w czasie jednej prelekcji.
                Każda prelekcja może pomieścić maksymalnie 5 słuchaczy.
                """;
    }

    void lecturesReport() {

    }

    void subjectsReport() {

    }

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }

    public boolean lecturesPlan() {
        for (int i = 0; i < lectures.size(); i++) {
            if (lectures.get(i).getSeats() == 0) {
                return false;
            } else {

                String id = String.valueOf(i + 1);
                System.out.println("[" + id + "] " +
                        "Lecture name: " + lectures.get(i).getName() +
                        ", Lecture subject: " + lectures.get(i).getSubject() +
                        ", Lecture start time: " + lectures.get(i).getStartTime() +
                        ", Lecture end time: " + lectures.get(i).getEndTime() +
                        ", Available seats: " + lectures.get(i).getSeats());
            }
        }
        return true;
    }

    public String singleLecture(Long id) {
        if (id != null) {
            return "[" + id + "] " +
                    "Lecture name: " + lectures.get(Math.toIntExact(id - 1)).getName() +
                    ", Lecture subject: " + lectures.get(Math.toIntExact(id - 1)).getSubject() +
                    ", Lecture start time: " + lectures.get(Math.toIntExact(id - 1)).getStartTime() +
                    ", Lecture end time: " + lectures.get(Math.toIntExact(id - 1)).getEndTime() +
                    ", Available seats: " + lectures.get(Math.toIntExact(id - 1)).getSeats();
        }
        return "";
    }

    public void addSeat(int i) {
        i-=1;
        lectures.set(i, lectures.get(i)).setSeats(lectures.get(i).getSeats() + 1);
    }

    public void removeSeat(int i) {
        i-=1;
        lectures.set(i, lectures.get(i)).setSeats(lectures.get(i).getSeats() - 1);
    }

}
