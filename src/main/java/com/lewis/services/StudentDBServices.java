package com.lewis.services;

import com.lewis.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class StudentDBServices {

    public void createTable(){

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Student student = new Student();

        t.commit();
        System.out.println("Successfully created student table");
        factory.close();
        session.close();

    }

    public void addStudents(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Student sone = new Student();
        sone.setFristName("Morgan");
        sone.setLastName("Jones");
        sone.setEmail("mj@gmail.com");
        sone.setMajor("Biology");

        Student stwo = new Student();
        stwo.setFristName("Jane");
        stwo.setLastName("Donald");
        stwo.setEmail("jdonald@gmail.com");
        stwo.setMajor("Aviation");

        Student sthree = new Student();
        sthree.setFristName("Jeffrey");
        sthree.setLastName("Smith");
        sthree.setEmail("jsmith@gmail.com");
        sthree.setMajor("Art");

        Student sfour = new Student("Nancy", "Gordon", "ngordon@gmail.com",  "Chemistry");
        Student sfive = new Student("Norm", "Jones", "nj@gmail.com", "Accounting");





           session.persist(sone);
           session.persist(stwo);
          session.persist(sthree);
          session.persist(sfour);
          session.persist(sfive);


        t.commit();
        System.out.println("Successfully saved");
        factory.close();
        session.close();

    }

    public void findStudent(){
        SessionFactory factory = new	Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        int STUDENT_ID = 2;
        Student s = session.load(Student.class, STUDENT_ID);

        System.out.println("FirstName: " + s.getFristName());
        System.out.println("LastName: " + s.getLastName());
        System.out.println("Email: " + s.getEmail());

        tx.commit();
        factory.close();
        session.close();

    }

    public void updateStudent(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student s = new Student();
        s.setId(3);  // modifying Jeffery
        s.setFristName("Matthew");
        s.setLastName("Martin");
        s.setEmail("mmartin@gmail.com");
        session.merge(s);
        session.getTransaction().commit();
        session.close();

    }
    public void deleteStudent(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student s = new Student();
        s.setId(3);
        session.remove(s);
        tx.commit();
        session.close();
        factory.close();

    }

}
