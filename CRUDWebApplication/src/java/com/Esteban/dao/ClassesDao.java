package com.Esteban.dao;

import com.Esteban.model.Classes;
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
public class ClassesDao implements ClassesDaoLocal {
    
     @PersistenceContext
    private EntityManager em;

    @Override
    public void addStudentToClass(Classes classes) {
        em.persist(classes);
        updateStudentCount(classes.getCoursesId());
        
    }

    @Override
    public List<Classes> getClassStudents(Integer courseId) {
        return em.createQuery("SELECT s FROM Classes s WHERE s.coursesId = :coursesId ", Classes.class)
                .setParameter("coursesId", courseId)
                .getResultList();
    }

    @Override
    public List<Classes> getStudentClasses(Integer studentId) {
        return em.createQuery("SELECT s FROM Classes s WHERE s.studentId = :studentId ", Classes.class)
                .setParameter("studentId", studentId)
                .getResultList();
    }

    @Override
    public List<Classes> getClasses() {
        return em.createQuery("SELECT c FROM Classes c", Classes.class).getResultList();
    }
    
    private void updateStudentCount(int coursesId) {
        Long count = (Long) em.createQuery(
            "SELECT COUNT(c) FROM Classes c WHERE c.coursesId = :coursesId")
            .setParameter("coursesId", coursesId)
            .getSingleResult();

        Courses course = em.find(Courses.class, coursesId);
        if (course != null) {
            course.setStudentsQuantity(count.intValue());
            em.merge(course);
        }
    }
    
    
}
