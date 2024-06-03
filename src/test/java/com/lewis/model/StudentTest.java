package com.lewis.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StudentTest {

    @ParameterizedTest
    @CsvSource({
            "Alexis, Evans, Computer Science",
            "Ken, Jones, Mathematics",
            "Alice, Walker, Literature"

    })
    public void testStudentConstructorGetterSetter(String fname, String lname, String major){
        Student student = new Student();

        //set studetn instance
        student.setFristName(fname);
        student.setLastName(lname);
        student.setMajor(major);

        //test if the set fname, lname, major are equal arguments pass in.
        Assertions.assertEquals(fname, student.getFristName());
        Assertions.assertEquals(lname, student.getLastName());
        Assertions.assertEquals(major, student.getMajor());


        Assertions.assertNotNull(student.getCourses());
        Assertions.assertTrue(student.getCourses().isEmpty());

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2,3})
    public void testWithValueSource(int argument){
        Assertions.assertTrue(argument > 0 && argument < 4);
    }

    @Test
    public void testGetEmail(){
        //Given:  A Student, A email , set the expected student email
         Student student = new Student();
         String expectedEmail = "ljones@gmail.com";
         student.setEmail(expectedEmail);

         //When   - The student gets a email
        String actualEmail = student.getEmail();

        //Then
        //Test the email that was fetched (using the getEmail(), and check if it is equal to the email that was set
        Assertions.assertEquals(expectedEmail, actualEmail);

       // Assertions.assertNotEquals(expectedEmail, actualEmail);
    }
}
