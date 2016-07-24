<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ie.silvia.model.Users"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="libs.jsp" %>

<title>My tasks</title>
</head>
<body>
<!-- navbar goes here -->
<%@ include file="navbar.jsp" %>
	<h2>My current tasks</h2>
	<%
		Users user = (Users)request.getAttribute("CURRENT_USER");
		out.println("USER: " + user.getUsername() + " " + user.getId()+"<br/>");
	%>
	<hr/>
	<ul>
	<c:forEach items="${MY_TASKS}" var="task">
		<li>${task.id} - ${task.content}: status: ${task.statusid.statusname} <a href="<%= request.getContextPath() %>/tasks/viewtask/${task.id}">View</a>  <a href="<%= request.getContextPath() %>/tasks/edit/${task.id}">Edit</a></li>
	</c:forEach>
	</ul>
</body>
</html>