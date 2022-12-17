<%@ page import="com.example.demoworking.models.ClassSubject" %>
<%@ page import="com.example.demoworking.models.Student" %>
<%@ page import="com.example.demoworking.models.ClassSubject" %>
<%@ page import="com.example.demoworking.models.ClassReport" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Learner Academy</title>
    <link rel="stylesheet" href="style.css">
    <style>
        .class-report-table{
            max-height: 280px;
            overflow-y: auto;
        }
    </style>
</head>
<body>
<%! ClassReport classReport;%>
<% classReport = (ClassReport) request.getAttribute("classDetails"); %>
<div class="container">
    <div class="side-menu">
        <jsp:include page="sideMenu.jsp"/>
    </div>
    <div class="content report-content">
        <h1><% out.println(classReport.getMyClass().getName()); %></h1>
        <form style="display: flex;align-items: center;" action="${pageContext.request.contextPath}/add-class-subject"
              method="post">
            <h1>Curriculum</h1>
            <div class="spacer"></div>
            <input name="classId" style="display: none;" value=<%out.println(classReport.getMyClass().getId());%>>
            <jsp:include page="dropDownSubject.jsp"/>
            <jsp:include page="dropDownTeacher.jsp"/>
            <button class="btn report-btn" type="submit">Add</button>
        </form>
        <div class="class-report-table" style="flex-grow: 1;">
            <%
                if (!classReport.getSubjects().isEmpty()) {
                    List<ClassSubject> subjects = classReport.getSubjects();
                    out.println("<table>");
                    out.println(ClassSubject.tableHeaderHtml());
                    for (ClassSubject s : subjects)
                        out.println(s.tableRowHtml());
                    out.println("</table>");
                } else
                    out.println("Class has no subjects");
            %>
        </div>
        <h1>Students</h1>
        <div class="class-report-table" style="flex-grow: 1;">
            <%
                if (!classReport.getStudents().isEmpty()) {
                    List<Student> students = classReport.getStudents();
                    out.println("<table>");
                    out.println(Student.tableHeaderHtmlForClassReport());
                    for (Student s : students)
                        out.println(s.tableRowHtmlForClassReport());
                    out.println("</table>");
                } else
                    out.println("Class has no students");
            %>
        </div>
    </div>
</div>
</body>
</html>