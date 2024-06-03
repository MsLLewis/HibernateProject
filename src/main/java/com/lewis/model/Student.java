package com.lewis.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Entity Student Class defines a student and is the owner
 * of a M:1 association with School and a 1:M associatoin
 * with Assignments
 */
@NamedQueries({
        @NamedQuery(name="updateStudentById", query = "UPDATE Student set lastName = :name WHERE  id = :id"),
})
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

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(targetEntity = Assignment.class, cascade = {CascadeType.ALL})
    private List<Assignment> assignments;

    @OneToOne
    @JoinColumn(name = "student_profile_id")//foreign key column name in Student table
    private StudentProfile studentProfile;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();


    //Empty constructor
    public Student(){
        this.fristName = "";
        this.lastName = "";
        this.email = "";
        this.major = "";
    }

    public Student(int id, String major){
        this.id = id;
        this.major = major;
    }

    //Constructor with params
    public Student(String fristName, String lastName, String email, String major) {
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
    }

    //Constructor with params and school association
    public Student(String fristName, String lastName, String email, String major, School school) {
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.school = school;
    }

    public Student(String fristName, String lastName, String email, String major, Set<Course> courses) {
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.courses = courses;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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
                ", school=" + school +
                ", assignments=" + assignments +
                ", studentProfile=" + studentProfile +
                ", courses=" + courses +
                '}';
    }
}
