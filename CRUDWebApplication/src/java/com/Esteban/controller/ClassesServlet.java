package com.Esteban.controller;

import com.Esteban.dao.ClassesDaoLocal;
import com.Esteban.model.Classes;
import jakarta.ejb.EJB;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProfessorServlet", urlPatterns = {"/ProfessorServlet"})
public class ClassesServlet extends HttpServlet {

    @EJB
    private ClassesDaoLocal classesDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String studentIdStr = request.getParameter("studentId");
        // Corregido: ahora lee "coursesId" que es lo que envía el JSP
        String courseIdStr = request.getParameter("coursesId");

        int studentId = 0;
        int coursesId = 0;

        if (studentIdStr != null && !studentIdStr.isEmpty()) {
            studentId = Integer.parseInt(studentIdStr);
        }

        if (courseIdStr != null && !courseIdStr.isEmpty()) {
            coursesId = Integer.parseInt(courseIdStr);
        }

        Classes classes = new Classes(null, studentId, coursesId);
        request.setAttribute("classes", classes);

        if ("Add".equalsIgnoreCase(action)) {
            classesDao.addStudentToClass(classes);
        }

        if ("SearchByCourse".equalsIgnoreCase(action)) {
            if (coursesId != 0) {
                request.setAttribute("SearchClassStudents", classesDao.getClassStudents(coursesId));
            }
        }

        if ("SearchByStudent".equalsIgnoreCase(action)) {
            if (studentId != 0) {
                request.setAttribute("SearchStudentInfo", classesDao.getStudentClasses(studentId));
            }
        }

        request.getRequestDispatcher("professorInfo.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
