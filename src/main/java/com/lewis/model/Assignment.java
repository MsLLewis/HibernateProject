package com.lewis.model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity Assignment class defines a student assignment
 * and is associated with Student class in a 1:M relationship
 */
@Entity
@Table
public class Assignment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private Date dueDate;

    public Assignment(){}

    public Assignment(String title, Date dueDate) {
        this.title = title;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
