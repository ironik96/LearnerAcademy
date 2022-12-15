<%@ page import="java.util.List" %>
<%@ page import="com.example.demoworking.Database" %>
<%@ page import="com.example.demoworking.models.Class" %>
<form action="${pageContext.request.contextPath}/add-class" method="post" >
    <h1>Classes</h1>
    <div class="spacer"></div>
    <label class="form-label">
        <input type="text" class="form-input" placeholder="name" name="className"/>
        <%
            if (request.getAttribute("classSuccess") != null)
                out.println("<p class=\"success\">" + request.getAttribute("classSuccess").toString() + "</p>");
            if (request.getAttribute("classError") != null)
                out.println("<p class=\"fail\">" + request.getAttribute("classError").toString() + "</p>");
        %>
    </label>
    <button class="btn" type="submit">Add</button>
</form>
<%
    Database db = (Database) session.getAttribute("database");
    List<Class> classes = db.readClasses();
    out.println("<table>");
    out.println(Class.tableHeaderHtml());
    for (Class c : classes)
        out.println(c.tableRowHtml());
    out.println("</table>");
%>
