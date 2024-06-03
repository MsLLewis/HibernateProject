package com.lewis.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;

public class StudentMajorTest {

    @Test
    public void testDoesMajorComply(){
        boolean expectedResult = true;

        StudentMajor studentMajor = new StudentMajor("Computer Science");
        boolean actualResult = studentMajor.doesMajorComply();
        Assertions.assertEquals(expectedResult, actualResult, "Major conditions fialed");
        System.out.println("Major conditions success!");

    }

    @Test
    public void testDoesMajorExist(){
        StudentMajor studentMajor = new StudentMajor("Mathematics");
        try{
            studentMajor.doesNotAlreadyExist();
            Assertions.fail("Expected SQLException to be thrown");
        }catch (SQLException e){
            //Expected exception
            System.out.println("SQL Exception ws thrown as expected");
        }

    }

    @Test
    public void tstEmptyMajor(){
        StudentMajor studentMajor = new StudentMajor(null);
        try{
            studentMajor.doesNotAlreadyExist();
            Assertions.fail("Expected NullPointerException to be throw");
        }catch (NullPointerException e){
            //Expected exception
            System.out.println("Null Exception was thrown as expected");
        }catch (SQLException e){
            Assertions.fail("Expected NullPointerException but got SQLException");
        }
    }
}
