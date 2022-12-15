<%@ page import="com.example.demoworking.models.Subject" %>
<%@ page import="com.example.demoworking.Database" %>
<%@ page import="java.util.List" %>
<form action="${pageContext.request.contextPath}/add-subject" method="post" id="subject">
    <h1>Subjects</h1>
    <div class="spacer"></div>
    <label class="form-label">
        <input type="text" class="form-input" placeholder="title" name="subjectTitle"/>
        <%
            if (request.getAttribute("subjectSuccess") != null)
                out.println("<p class=\"success\">" + request.getAttribute("subjectSuccess").toString() + "</p>");
            if (request.getAttribute("subjectError") != null)
                out.println("<p class=\"fail\">" + request.getAttribute("subjectError").toString() + "</p>");
        %>
    </label>
    <button class="btn" type="submit">Add</button>
</form>
<%
    Database db = (Database) session.getAttribute("database");
    List<Subject> subjects = db.readSubjects();
    out.println("<table>");
    out.println(Subject.tableHeaderHtml());
    for (Subject s : subjects)
        out.println(s.tableRowHtml());
    out.println("</table>");
%>