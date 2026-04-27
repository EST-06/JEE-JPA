/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Esteban.model;

/**
 *
 * @author esteg
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author esteg
 */
@Entity
@Table
public class Courses implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int courseId;
    @Column
    private String name;
    @Column
    private Integer credits;
    @Column
    private Integer semester;
    @Column 
    private Integer studentsQuantity;

    public Courses() {
    }

    public Courses(int courseId, String name, Integer credits, Integer semester, Integer studentsQuantity) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.semester = semester;
        this.studentsQuantity = studentsQuantity;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getStudentsQuantity() {
        return studentsQuantity;
    }

    public void setStudentsQuantity(Integer studentsQuantity) {
        this.studentsQuantity = studentsQuantity;
    }
    
   

}
