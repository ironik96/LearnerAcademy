<%@ page import="java.io.File" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Learner Academy</title>
    <link rel="stylesheet" href="style.css">
    <script src="index.js" defer></script>
</head>
<body>
<div class="container">
    <div class="side-menu">
        <jsp:include page="sideMenu.jsp"/>
    </div>
    <div class="content">
        <jsp:include page="subjectContent.jsp"/>
    </div>
</div>
</body>
</html>