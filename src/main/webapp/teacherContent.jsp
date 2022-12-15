<%@ page import="com.example.demoworking.Database" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demoworking.models.Teacher" %>
<form action="${pageContext.request.contextPath}/add-teacher" method="post" id="teacher">
    <h1>Teachers</h1>
    <div class="spacer"></div>
    <label class="form-label">
        <input type="text" class="form-input" placeholder="name" name="teacherName"/>
        <%
            if (request.getAttribute("teacherSuccess") != null)
                out.println("<p class=\"success\">" + request.getAttribute("teacherSuccess").toString() + "</p>");
            if (request.getAttribute("teacherError") != null)
                out.println("<p class=\"fail\">" + request.getAttribute("teacherError").toString() + "</p>");
        %>
    </label>
    <button class="btn" type="submit">Add</button>
</form>
<%
    Database db = (Database) session.getAttribute("database");
    List<Teacher> teachers = db.readTeachers();
    out.println("<table>");
    out.println(Teacher.tableHeaderHtml());
    for (Teacher t : teachers)
        out.println(t.tableRowHtml());
    out.println("</table>");
%>
