package com.lewis.utility;

import com.lewis.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

/**
 * DBUtility class provides database connectivity
 * and inserts data into tables.
 */
public class DBUtility {

    public static Session connectToDB(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        return factory.openSession();
    }

    public void enterCourseData(){
        Session session = connectToDB();
        Transaction t = session.beginTransaction();

        //----Create Course/class Entity set one----
        Course course1 = new Course("Java Development");
        Course course2 = new Course("Mathematics");
        Course course3 = new Course("Physics");

        //------  Store Course/ Class  --------
        session.persist(course1);
        session.persist(course2);
        session.persist(course3);

        //-----Create a Set of Courses /Class one --------
        Set<Course> courseSet1 = new HashSet<Course>();
        courseSet1.add(course1);
        courseSet1.add(course2);
        courseSet1.add(course3);

        //-----Create a Set of Courses /Class two --------
        Set<Course> courseSet2 = new HashSet<Course>();
        courseSet2.add(course2);
        courseSet2.add(course3);
        courseSet2.add(course1);

        //-----Create a Set of Courses /Class three --------
        Set<Course> courseSet3 = new HashSet<Course>();
        courseSet3.add(course3);
        courseSet3.add(course1);
        courseSet3.add(course2);

        //Create Student instances
        Student s1 = new Student("Jane", "Doe","jdoe@gmail.com","Physics", courseSet1);
        Student s2 = new Student("Kathy", "Hampton","khampton@gmail.com","Computer Science", courseSet2);
        Student s3 = new Student("Alvin", "Earl","aearl@gmail.com","Accounting", courseSet3);

        //persist data
        session.persist(s1);
        session.persist(s2);
        session.persist(s3);
        t.commit();

    }

    public void enterStudent(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String fname = input.nextLine();
        System.out.println("Enter last name: ");
        String lname = input.nextLine();
        System.out.println("Enter email: ");
        String email = input.nextLine();
        System.out.println("Enter major: ");
        String major = input.nextLine();
        System.out.println("Enter bio: ");
        String bio = input.nextLine();
        System.out.println("Enter school name: ");
        String school = input.nextLine();
        insertStudentWithProfile(fname,lname,email,major, bio,school );

    }

    public void insertStudentWithProfile(String fname, String lname, String email, String major, String bio, String school_name){
        Session session = connectToDB();
        Transaction transaction = session.beginTransaction();

        //Create a new StudentProfile
        StudentProfile profile = new StudentProfile();
        profile.setBio(bio);
        session.persist(profile);

        //Create new School
        School school = new School();
        school.setName(school_name);
        session.persist(school);

        //Create a new Student
        Student student = new Student();
        student.setFristName(fname);
        student.setLastName(lname);
        student.setEmail(email);
        student.setMajor(major);
        student.setStudentProfile(profile); //Student profile associated with Student class -- onetoone relationship
        student.setSchool(school);


        //persisting student to database
        session.persist(student);

        transaction.commit();


    }


    /**
     * Inserts data into the School and Student tables.
     */
    public void insertData(){
        //Connect to DB
        Session session = connectToDB();
        Transaction transaction = session.beginTransaction();

        //create schools
        School school1 = new School("School of Computer Science");
        School school2 = new School("School of Biology");
        School school3 = new School("School of Mathematics");
        School school4 = new School("School of Psychology");


        //create student
        Student s1 = new Student("Brooke", "Smith", "bsmith@gmail.com", "Computer Science", school1);
        Student s2 = new Student("Jean", "Andrew", "jandrew@gmail.com", "Mathematics", school3);
        Student s3 = new Student("Dan", "Jones", "djones@gmail.com", "Psychology", school4);
        Student s4 = new Student("Morgan", "Smith", "msmith@gmail.com", "Biology", school2);
        Student s5 = new Student("Cassy", "Pryor", "cpryor@gmail.com", "Computer Science", school1);
        Student s6 = new Student("Angela", "Johnson", "ajohnson@gmail.com", "Biology", school2);
        Student s7 = new Student("Mick", "Jagger", "mjagger@gmail.com", "Psychology", school4);

        //Store schools in database
        session.persist(school1);
        session.persist(school2);
        session.persist(school3);
        session.persist(school4);

        //Store students in database
        session.persist(s1);
        session.persist(s2);
        session.persist(s3);
        session.persist(s4);
        session.persist(s5);
        session.persist(s6);
        session.persist(s7);
        transaction.commit();


    }

    /**
     * Inserts data into the Assignment table and creates a new student
     * and new school to insert into tables and assigns many homework assignments to
     * the new student.
     */
    public void insertAssignments(){
        //Connect to DB
        Session session = connectToDB();
        Transaction transaction = session.beginTransaction();

        //create new Assignments
        Assignment a1 = new Assignment("Homework 1", new Date());
        Assignment a2 = new Assignment("Homework 2", new Date());
        Assignment a3 = new Assignment("Homework 3", new Date());
        Assignment a4 = new Assignment("Homework 4", new Date());

        //Add asssignment entity objects to the list
        ArrayList<Assignment> assignmentList = new ArrayList<>();
        assignmentList.add(a1);
        assignmentList.add(a2);
        assignmentList.add(a3);
        assignmentList.add(a4);
        //persist to assignment table
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);
        session.persist(a4);

        //Create a new school and student to add assignments
        School another_school = new School("School of Law");
        Student new_student = new Student("Meagan", "Waller", "mwaller@gmail.com", "Law", another_school);
        session.persist(another_school);

        //set assignments for new student
        new_student.setAssignments(assignmentList);

        //Store new_student
        session.persist(new_student);
        transaction.commit();


    }

}
