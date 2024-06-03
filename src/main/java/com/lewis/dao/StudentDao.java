package com.lewis.dao;

import com.lewis.model.Student;

import java.sql.*;

public class StudentDao {

    private Connection connection;


    public StudentDao(Connection connection){
        this.connection = connection;
    }

    public Student getStudentById(int id) throws SQLException {
        String query = "SELECT STUDENT_ID, major FROM students WHERE STUDENT_ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int studentId = resultSet.getInt("STUDENT_ID");
                    String major = resultSet.getString("major");
                    return new Student(studentId, major);
                } else {
                    return null; // No student found with the given ID
                }
            }
        }


    }

    //Method add a student to the database for testing purposes
    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (STUDENT_ID, major) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getMajor());
            preparedStatement.executeUpdate();

        }

    }

    //Method delete a student from the database for testing purposes
    public void deleteStudent(int id) throws SQLException {
        String query = "DELETE FROM students WHERE STUDENT_ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

}
