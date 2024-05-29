package com.lewis.service;

import com.lewis.model.Student;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class StudentHQLService {

    public StudentHQLService(){}

    private Session connectToDB(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        return factory.openSession();
    }

    /**
     * Using HQL FROM Clause to get all employees
     */
    public void getAllStudents(){
        Session session = connectToDB();
        String hql = "FROM Student";
        TypedQuery<Student> query = session.createQuery(hql, Student.class);

        List<Student> results = query.getResultList();
        for(Student s : results){
            System.out.println("Student Id: " +s.getId() + "|" + " First name:" + s.getFristName() +"|"+ " Last name: "
                    + s.getLastName() + " | "+ "Email: " + s.getEmail() +"|"+ "Major" + s.getMajor());
        }
    }

    /**
     * Uses the HQL WHERE Clause to get one Student
     */
    public void getStudent(){
        Session session = connectToDB();
        String hql = "FROM Student s WHERE s.id = 4";
        TypedQuery<Student> query = session.createQuery(hql, Student.class);

        List<Student> results = query.getResultList();
        for(Student s : results){
            System.out.println("Student Id: " +s.getId() + "|" + " First name:" + s.getFristName() +"|"+ " Last name: "
                    + s.getLastName() + " | "+ "Email: " + s.getEmail() +"|"+ "Major" + s.getMajor());
        }
    }

    /**
     * Using HQL's ORDER BY Clause to extract id greater than 3
     */
    public void getStudentGreaterThanIdValue(){
        Session session = connectToDB();
        String hql = "FROM Student S WHERE S.id > 3 ORDER BY S.major DESC";
        TypedQuery<Student> query = session.createQuery(hql, Student.class);

        List<Student> results = query.getResultList();
        for(Student s : results){
            System.out.println("Student Id: " +s.getId() + "|" + " First name:" + s.getFristName() +"|"+ " Last name: "
                    + s.getLastName() + " | "+ "Email: " + s.getEmail() +"|"+ "Major" + s.getMajor());
        }

    }

    public void getStudentNameAndEmail(){
        Session sesssion = connectToDB();
        String hql = "SELECT S.email, S.lastName FROM Student AS S";

        TypedQuery<Object[]> query = sesssion.createQuery(hql, Object[].class);

        List<Object[]>  results = query.getResultList();
        for(Object[] o : results){
            System.out.println("email: " + o[0] + " | " + " lastname: " + o[1]);
        }

    }

    public void countStudentAndGroupByLastName(){
        Session session = connectToDB();
        String hql = "SELECT COUNT(S.id), S.lastName FROM Student S GROUP BY S.lastName";
        TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> results = query.getResultList();
        for(Object[] o : results){
            System.out.println("id: " + o[0] + " | " + " lastname: " + o[1]);
        }
    }

    public void useParameterizedQuery(){
        Session session = connectToDB();
        String hql = "FROM Student s WHERE s.id = :id";
        TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
        query.setParameter("id", 4);
        List<Object[]> result = query.getResultList();
        for(Object[] o : result){
            System.out.println(o[0]);
        }

    }

    /**
     * Using NamedQuery in HQL
     */
    public void updateStudentById(){
        Session session = connectToDB();
        Transaction t = session.beginTransaction();
        TypedQuery<Student> query = session.getNamedQuery("updateStudentById");
        query.setParameter("name", "Williams");
        query.setParameter("id", 2);
        int rowsAffected = query.executeUpdate();
        if(rowsAffected > 0){
            System.out.println(rowsAffected + " (s) were updated ");
        }
        t.commit();
        System.out.println("Successfully Saved");

    }

}
