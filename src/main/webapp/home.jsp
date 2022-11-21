<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<%
	if ( session.getAttribute("username") == null ) {
		response.sendRedirect(request.getContextPath() + "/auth.jsp");
	}
%>
<body>
	<h1>Home</h1>
	<p>Welcome, <%= (String) session.getAttribute("username") %>!</p>
	<p>
		<a href="LogoutServlet">Logout</a>
	</p>
</body>
</html>