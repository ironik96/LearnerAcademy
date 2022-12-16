<%@ page import="java.util.List" %>
<%@ page import="com.example.demoworking.Database" %>
<%@ page import="com.example.demoworking.models.Student" %>
<form action="${pageContext.request.contextPath}/class-report">
    <jsp:include page="dropDown.jsp"/>
    <div class="spacer"></div>
    <button class="btn" type="submit">Show Report</button>
</form>

