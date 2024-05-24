package com.lewis;

import com.lewis.services.StudentDBServices;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        StudentDBServices obj = new StudentDBServices();
     //  obj.createTable();
       //  obj.addStudents();
        //obj.findStudent();

      //  obj.updateStudent();
        obj.deleteStudent();
    }
}