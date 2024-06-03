package com.lewis.model;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class StudentMajor {

    private String major;

    public StudentMajor(String major){
        this.major = major;
    }

    public boolean doesMajorComply(){
        //Simple compliance check:  major should not be empty and should be recognized
        return major !=null && !major.trim().isEmpty() && isRecognizedMajor(major);
    }

    private boolean isRecognizedMajor(String major){
        //List of recognized majors
        String [] recognizedMajors = {"Computer Science", "Mathematics", "Physics", "Chemistry", "Biology"};
        for(String recognizedMajor: recognizedMajors){
            if(recognizedMajor.equalsIgnoreCase(major)){
                return true;
            }
        }
        return false;
    }

    public void doesNotAlreadyExist() throws SQLException {
        if(major == null){
            throw new NullPointerException(("Major is null"));
        }

        //Simulate checking the majojr in the database and throw and SQL exception
        throw new SQLException(("Major already exists in the database"));
    }

}
