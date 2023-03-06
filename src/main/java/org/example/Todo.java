package org.example;



import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Todo {

    @Id
    @GeneratedValue()
    private int Id;
    private String title;
    private String details;
    private LocalDate dateDue;
    private LocalTime timeDue;
    private LocalDateTime dateAdded;

    public Todo() {
        dateAdded = LocalDateTime.now();
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
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
