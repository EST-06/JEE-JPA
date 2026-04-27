/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Esteban.dao;

import com.Esteban.model.Courses;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author esteg
 */
@Local
public interface CoursesDaoLocal {

    void addCourse(Courses courses);

    void editCourse(Courses courses);

    void deleteCourse(int courseId);

    Courses getCourse(int courseId);

    List<Courses> getAllCourses();
}
