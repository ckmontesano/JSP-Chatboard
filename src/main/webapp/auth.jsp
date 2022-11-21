<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auth</title>
</head>
<%
	if ( session.getAttribute("username") != null ) {
		response.sendRedirect(request.getContextPath() + "/home.jsp");
	}
%>
<body>
	<h1>Login</h1>
	<p>Welcome back!</p>
	<form action="AuthServlet" method="POST">
		<input type="hidden" name="authType" value="login" />
		<label for="username">Username</label>
		<input name="username" type="text" maxlength="20" />
		<input name="password" type="password" maxlength="20" />
		<input type="submit" value="Login" />
	</form>
</body>
</html>