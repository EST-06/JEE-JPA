package com.Esteban.dao;

import com.Esteban.model.Classes;
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
    
    
}
