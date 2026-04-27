/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Esteban.controller;

import com.Esteban.dao.CoursesDaoLocal;
import com.Esteban.model.Courses;
import jakarta.ejb.EJB;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author esteg
 */
@WebServlet(name = "CoursesServlet", urlPatterns = {"/CoursesServlet"})
public class CoursesServlet extends HttpServlet {
    @EJB
    private CoursesDaoLocal courseDao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getParameter("action");
        String courseIdStr = request.getParameter("courseId");

        int courseId = 0;
        if (courseIdStr != null && !courseIdStr.equals("")) {
            courseId = Integer.parseInt(courseIdStr);
        }

        String name = request.getParameter("name");

        String creditsStr = request.getParameter("credits");
        Integer credits = null;
        if (creditsStr != null && !creditsStr.equals("")) {
            credits = Integer.parseInt(creditsStr);
        }

        String semesterStr = request.getParameter("semester");
        Integer semester = null;
        if (semesterStr != null && !semesterStr.equals("")) {
            semester = Integer.parseInt(semesterStr);
        }

        String studentsQuantityStr = request.getParameter("studentsQuantity");
        Integer studentsQuantity = null;
        if (studentsQuantityStr != null && !studentsQuantityStr.equals("")) {
            studentsQuantity = Integer.parseInt(studentsQuantityStr);
        }

        Courses course = new Courses(courseId, name, credits, semester, studentsQuantity);

        if ("Add".equalsIgnoreCase(action)) {
            courseDao.addCourse(course);
        } else if ("Edit".equalsIgnoreCase(action)) {
            courseDao.editCourse(course);
        } else if ("Delete".equalsIgnoreCase(action)) {
            courseDao.deleteCourse(courseId);
        } else if ("Search".equalsIgnoreCase(action)) {
            course = courseDao.getCourse(courseId);
        }

        request.setAttribute("course", course);
        request.setAttribute("allCourses", courseDao.getAllCourses());
        request.getRequestDispatcher("/courseInfo.jsp").forward(request, response);
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
