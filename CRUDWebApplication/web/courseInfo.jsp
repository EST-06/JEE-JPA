<%-- 
    Document   : courseInfo
    Created on : 27/04/2026, 4:31:34 p. m.
    Author     : esteg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Information</title>
    </head>
    <body>
        <h1>Course Information</h1>
        <form action="${pageContext.request.contextPath}/CoursesServlet" method="post">
            
            <table>
                <tr>
                    <td>Course ID</td>
                    <td><input type="text" name="courseId" value="${course.courseId}"/></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="${course.name}"/></td>
                </tr>
                <tr>
                    <td>Credits</td>
                    <td><input type="text" name="credits" value="${course.credits}"/></td>
                </tr>
                <tr>
                    <td>Semester</td>
                    <td><input type="text" name="semester" value="${course.semester}"/></td>
                </tr>
                <tr>
                    <td>Students Quantity</td>
                    <td><input type="text" name="studentsQuantity" value="${course.studentsQuantity}"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>CREDITS</th>
                <th>SEMESTER</th>
                <th>STUDENTS QUANTITY</th>
            </tr>
            <c:forEach items="${allCourses}" var="c">
                <tr>
                    <td>${c.courseId}</td>
                    <td>${c.name}</td>
                    <td>${c.credits}</td>
                    <td>${c.semester}</td>
                    <td>${c.studentsQuantity}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
