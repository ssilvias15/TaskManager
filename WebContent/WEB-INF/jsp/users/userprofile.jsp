<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="../libs.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<!-- navbar goes here -->
	<%@ include file="../navbar.jsp"%>
<h2>My profile</h2>

<h3>User information</h3>
Username: ${CURRENT_USER.username}<br/>
Password: ${CURRENT_USER.password}<br/>
<hr/>



<c:set var="thepath" value="/TaskManagerDB/users/profile"></c:set>


<form:form method="POST" action="${thepath}">
	<form:hidden path="id"/>
	Username: <form:input path="username"/><br/>
	Password: <form:input path="password"/><br/>
	<input type="submit"/ value="Edit profile data"/>
	
</form:form>
</body>
</html>