<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
<h2>ADD USER</h2>

<!-- User add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/adduser.htm"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	Username: <form:input path="username"/>
	<br/>
	Password: <form:input path="password"/>
	<br/>
	<input type="submit"/>
</form:form>


</body>
</html>