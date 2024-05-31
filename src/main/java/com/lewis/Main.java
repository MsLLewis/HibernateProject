package com.lewis;

import com.lewis.model.BookResponse;
import com.lewis.model.Person;
import com.lewis.utility.DBUtility;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        BookResponse bookResponse = new BookResponse();
        bookResponse.setBookIsbn("194-9876655");
        bookResponse.setAuthorName("Professor Lewis");
        bookResponse.setNetPrice(179.99);

        System.out.println(bookResponse);

        System.out.println("ISBN: " + bookResponse.getBookIsbn() + " | " + "Author Name: " + bookResponse.getAuthorName() + " | " + "Price: " + bookResponse.getNetPrice());




        /*
        Lombok annotations
         */

        Person person1 = new Person("Mary","Doe", 22);
        Person person2 = new Person("Mary","Doe", 22);

        Person person3 = new Person("Jane","Smith", 21);
//
//        //Test equals method
//        System.out.println("person1 equals person2: " + person1.equals(person2));
//        System.out.println("person1 equals person3: " + person1.equals(person3));
//
//        //Test hashCode method
        System.out.println("person1 hashCode: " + person1.hashCode());
        System.out.println("person2 hashCode: " + person2.hashCode());
        System.out.println("person3 hashCode: " + person3.hashCode());

        System.out.println("person 1 and person2 have same hashcode " +(person1.hashCode() == person2.hashCode()) );
        System.out.println("person 1 and person3 have different hashcode " +(person1.hashCode() == person3.hashCode()) );



//        Person person = new Person();
//        person.setFirstName("Diana");
//        person.setLastName("Cruz");
//        person.setAge(20);
//
//        System.out.println(person);
//        System.out.println("First Name: " + person.getFirstName() + " | " + "Last Name: " + person.getLastName() + " | " + "Age: " + person.getAge());










        /*
          Many-to-Many and One-To-One Relationship
         */
      //  DBUtility obj = new DBUtility();
      //  obj.enterCourseData();
       // obj.enterStudent();

        //obj.insertStudentWithProfile("Tracy","Lynn","tlynn@gmail.com","Medicine","Pre-Med Intern", "School of Medicine");
       //DBUtility.connectToDB();



        /*
           Run to test Many-to-One and One-to-Many associations
         */


       //  obj.insertData();
      //   obj.insertAssignments();


         /*
           Run to test HQL clauses
          */
//       StudentHQLService obj = new StudentHQLService();
//        obj.getAllStudents();
//        obj.getStudent();
//        obj.getStudentGreaterThanIdValue();
//        obj.getStudentNameAndEmail();
//        obj.countStudentAndGroupByLastName();
//        obj.useParameterizedQuery();
//        obj.updateStudentById();




    }
}