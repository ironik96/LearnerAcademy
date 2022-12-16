<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Learner Academy</title>
    <link rel="stylesheet" href="style.css">

</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/login" method="post" class="login">
        <h1>Welcome to Learner Academy</h1>

        <label class="form-label">
            <input type="text" class="form-input" placeholder="username" name="username"/>
            <%
                if (request.getAttribute("loginUsernameSuccess") != null)
                    out.println("<p class=\"success\">" + request.getAttribute("loginUsernameSuccess").toString() + "</p>");
                if (request.getAttribute("loginUsernameError") != null)
                    out.println("<p class=\"fail\">" + request.getAttribute("loginUsernameError").toString() + "</p>");
            %>
        </label>
        <label class="form-label">
            <input type="password" class="form-input" placeholder="password" name="password"/>
            <%
                if (request.getAttribute("loginPasswordSuccess") != null)
                    out.println("<p class=\"success\">" + request.getAttribute("loginPasswordSuccess").toString() + "</p>");
                if (request.getAttribute("loginPasswordError") != null)
                    out.println("<p class=\"fail\">" + request.getAttribute("loginPasswordError").toString() + "</p>");
            %>
        </label>
        <button class="btn" type="submit">log in</button>
    </form>
    <img src="images/site-login-art.png" alt="login-illustration">
</div>
</body>
</html>