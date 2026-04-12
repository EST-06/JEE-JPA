/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Esteban.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author esteg
 */
@Entity
@Table
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer classId;

    @Column
    private Integer studentId;

    @Column
    private Integer coursesId;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Integer getCoursesId() {
        return coursesId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setCoursesId(Integer coursesId) {
        this.coursesId = coursesId;
    }

    public Classes(Integer classId, Integer studentId, Integer courseId) {
        this.classId = classId;
        this.studentId = studentId;
        this.coursesId = courseId;
    }

    public Classes() {
    }

}
