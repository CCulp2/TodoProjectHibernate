package org.example;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Todo {
    String title;
    String details;
    LocalDate dateDue;
    LocalTime timeDue;
    LocalDateTime dateAdded;

    public Todo() {
        dateAdded = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDateDue() {
        return dateDue;
    }

    public void setDateDue(LocalDate dateDue) {
        this.dateDue = dateDue;
    }

    public LocalTime getTimeDue() {
        return timeDue;
    }

    public void setTimeDue(LocalTime timeDue) {
        this.timeDue = timeDue;
    }
}
