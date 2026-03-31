/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package com.Esteban.dao;

import com.Esteban.model.Student;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 
@author User*/
@Local
public interface StudentDaoLocal {

    void addStudent(Student student);

    void ediStudent(Student student);

    void deleteStudent(int studentId);

    Student getStudent(int studentId);

    List<Student> getAllStudents();

}