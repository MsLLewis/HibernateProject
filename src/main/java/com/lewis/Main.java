package com.lewis;

import com.lewis.utility.DBUtility;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*
           Run to test Many-to-One and One-to-Many associations
         */
        DBUtility obj = new DBUtility();
         DBUtility.connectToDB();
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