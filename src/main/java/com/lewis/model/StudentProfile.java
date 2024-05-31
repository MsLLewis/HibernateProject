package com.lewis.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class StudentProfile implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String bio;

        @OneToOne(mappedBy =  "studentProfile")
        private Student student;

        public StudentProfile(){}

    public StudentProfile(String bio, Student student) {
        this.id = id;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentProfile{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", student=" + student +
                '}';
    }
}
