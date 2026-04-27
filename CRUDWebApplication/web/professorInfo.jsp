<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Professor Menu</title>
</head>
<body>

<h1>Professor Menu</h1>

<!-- Formulario para agregar estudiante a clase -->
<h2>Add Student to Class</h2>
<form action="./ProfessorServlet" method="post">
    <table>
        <tr>
            <td>Student ID</td>
            <td><input type="text" name="studentId" value="${classes.studentId}"/></td>
        </tr>
        <tr>
            <td>Course ID</td>
            <td><input type="text" name="coursesId" value="${classes.coursesId}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Add"/>
            </td>
        </tr>
    </table>
</form>

<br>

<h2>All Classes</h2>

<table border="1">
    <tr>
        <th>Class ID</th>
        <th>Student ID</th>
        <th>Course ID</th>
    </tr>

    <c:forEach items="${allClasses}" var="c">
        <tr>
            <td>${c.classId}</td>
            <td>${c.studentId}</td>
            <td>${c.coursesId}</td>
        </tr>
    </c:forEach>
</table>
<!-- Formulario para buscar estudiantes de una clase -->
<h2>Search Students in a Class</h2>
<form action="./ProfessorServlet" method="post">
    <table>
        <tr>
            <td>Course ID</td>
            <td><input type="text" name="coursesId"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="SearchByCourse"/>
            </td>
        </tr>
    </table>
</form>

<c:if test="${not empty SearchClassStudents}">
    <h3>Students in Course</h3>
    <table border="1">
        <tr>
            <th>Class ID</th>
            <th>Student ID</th>
            <th>Course ID</th>
        </tr>
        <c:forEach items="${SearchClassStudents}" var="c">
            <tr>
                <td>${c.classId}</td>
                <td>${c.studentId}</td>
                <td>${c.coursesId}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>

<!-- Formulario para buscar clases de un estudiante -->
<h2>Search Classes of a Student</h2>
<form action="./ProfessorServlet" method="post">
    <table>
        <tr>
            <td>Student ID</td>
            <td><input type="text" name="studentId"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="SearchByStudent"/>
            </td>
        </tr>
    </table>
</form>

<c:if test="${not empty SearchStudentInfo}">
    <h3>Classes of Student</h3>
    <table border="1">
        <tr>
            <th>Class ID</th>
            <th>Student ID</th>
            <th>Course ID</th>
        </tr>
        <c:forEach items="${SearchStudentInfo}" var="c">
            <tr>
                <td>${c.classId}</td>
                <td>${c.studentId}</td>
                <td>${c.coursesId}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>