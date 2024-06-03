package com.lewis.dao;

import com.lewis.model.Student;

import org.junit.jupiter.api.*;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentDaoTest {

    private static Connection connection;
    private StudentDao studentDao;

    @BeforeAll
    static void setUpBeforeClass() throws SQLException {
        // Replace with your database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "root";
        connection = DriverManager.getConnection(url, username, password);
    }

    @BeforeEach
    void setUp() {
        studentDao = new StudentDao(connection);
    }

    @Test
    public void testGetStudentById() throws SQLException {
        // Arrange  - Given
        int expectedId = 25;
        String expectedMajor = "Computer Science";
        Student expectedStudent = new Student(expectedId, expectedMajor);
        studentDao.addStudent(expectedStudent);

        // Act --When
        Student actualStudent = studentDao.getStudentById(expectedId);

        // Assert Then
        assertEquals(expectedStudent.getId(), actualStudent.getId(), "Student IDs should match");
        assertEquals(expectedStudent.getMajor(), actualStudent.getMajor(), "Student majors should match");

        System.out.println("New Student: " + actualStudent);
    }



    @AfterEach
    void tearDown() throws SQLException {
        studentDao.deleteStudent(25);
    }

    @AfterAll
    static void tearDownAfterClass() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}
