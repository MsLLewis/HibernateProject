package com.lewis.model;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 *Entity School class defines a School and is
 * associated with Student in a M:1 relationship.
 * Many students can enroll in one School
 */
@Entity
@Table
public class School implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public School(){}

    public School(String name){
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
