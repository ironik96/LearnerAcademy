<%@ page import="java.util.List" %>
<%@ page import="com.example.demoworking.Database" %>
<%@ page import="com.example.demoworking.models.Student" %>
<form action="${pageContext.request.contextPath}/add-student" method="post">
    <h1>Students</h1>
    <div class="spacer"></div>
    <label class="form-label">
        <input type="text" class="form-input" placeholder="name" name="studentName"/>
        <%
            if (request.getAttribute("studentSuccess") != null)
                out.println("<p class=\"success\">" + request.getAttribute("studentSuccess").toString() + "</p>");
            if (request.getAttribute("studentError") != null)
                out.println("<p class=\"fail\">" + request.getAttribute("studentError").toString() + "</p>");
        %>
    </label>
    <jsp:include page="dropDown.jsp"/>
    <button class="btn" type="submit">Add</button>
</form>
<%
    Database db = (Database) session.getAttribute("database");
    List<Student> students = db.readStudents();
    out.println("<table>");
    out.println(Student.tableHeaderHtml());
    for (Student s : students)
        out.println(s.tableRowHtml());
    out.println("</table>");
%>
