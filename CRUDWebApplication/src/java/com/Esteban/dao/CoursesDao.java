/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Esteban.dao;

import com.Esteban.model.Courses;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author esteg
 */
@Stateless
public class CoursesDao implements CoursesDaoLocal{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addCourse(Courses courses) {
        em.persist(courses);
    }

    @Override
    public void editCourse(Courses courses) {
        em.merge(courses);
    }

    @Override
    public void deleteCourse(int courseId) {
        em.remove(getCourse(courseId));
    }

    @Override
    public Courses getCourse(int courseId) {
        return em.find(Courses.class, courseId);
    }

    @Override
    public List<Courses> getAllCourses() {
        return em.createQuery("SELECT c FROM Courses c", Courses.class).getResultList();
    }
    
}
