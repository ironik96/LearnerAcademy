<form action="${pageContext.request.contextPath}/class-report">
    <div style="display: flex; flex-direction: column; width: 100%;">
        <jsp:include page="dropDown.jsp"/>
        <%
            if (request.getAttribute("error") != null)
                out.println("<p class=\"fail\">" + request.getAttribute("error").toString() + "</p>");
        %>
    </div>
    <div class="spacer"></div>
    <button class="btn" type="submit">Show Report</button>
</form>

