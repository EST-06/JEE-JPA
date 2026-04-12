/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package com.Esteban.dao;

import com.Esteban.model.Classes;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author esteg
 */
@Local
public interface ClassesDaoLocal {
    
    void addStudentToClass(Classes classes);
    
    List<Classes> getClassStudents(Integer classId);
    
    List<Classes> getStudentClasses(Integer studentId);
    
    
}
