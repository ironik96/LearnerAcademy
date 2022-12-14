<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Learner Academy</title>
    <link rel="stylesheet" href="style.css">
    <script src="index.js" defer></script>
</head>
<body>
<%-- Add Teacher --%>
<form action="${pageContext.request.contextPath}/add-teacher" method="post" id="teacher">
    <h1>Add a Teacher</h1>
    <label>
        <input type="text" placeholder="name" name="teacherName"/>
    </label>
    <%
        if(request.getAttribute("teacherSuccess") != null)
            out.println("<p class=\"success\">"+request.getAttribute("teacherSuccess").toString()+"</p>");
        if(request.getAttribute("teacherError") != null)
            out.println("<p class=\"fail\">"+request.getAttribute("teacherError").toString()+"</p>");
    %>
    <input type="submit">
</form>

<%-- Add Subject --%>
<form action="${pageContext.request.contextPath}/add-subject" method="post" id="subject">
    <h1>Add a Subject</h1>
    <label>
        <input type="text" placeholder="title" name="subjectTitle"/>
    </label>
    <%
        if(request.getAttribute("subjectSuccess") != null)
            out.println("<p class=\"success\">"+request.getAttribute("subjectSuccess").toString()+"</p>");
        if(request.getAttribute("subjectError") != null)
            out.println("<p class=\"fail\">"+request.getAttribute("subjectError").toString()+"</p>");
    %>
    <input type="submit">
</form>
</body>
</html>