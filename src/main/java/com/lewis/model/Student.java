package com.lewis.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name= "students")
public class Student {
    @Column(name = "STUDENT_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fristName;
    private String lastName;
    private String email;
    private String major;

    public Student(){
        this.fristName = "";
        this.lastName = "";
        this.email = "";
        this.major = "";
    }

    public Student(String fristName, String lastName, String email, String major) {
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isValid = true;
        if (obj instanceof Student) {
            Student other = (Student) obj;
            boolean sameId = (this.id == other.getId());
            boolean sameFirstName = (this.fristName.equals(other.getFristName()));
            boolean sameLastName = (this.lastName.equals(other.getLastName()));
            boolean sameEmail = (this.email.equals(other.getEmail()));
            boolean sameMajor = (this.major.equals(other.getMajor()));
            if (sameId && sameFirstName && sameLastName && sameEmail && sameMajor) {
                isValid = true;
            }else {
                isValid = false;
            }
        }
        return isValid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFristName(), getLastName(), getEmail(), getMajor());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fristName='" + fristName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                '}';
    }


}
