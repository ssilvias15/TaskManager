<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../libs.jsp" %>
</head>
<body>

<%@ include file="../navbar.jsp" %>

<h2>Add task</h2>


<c:set var="thepath" value="/TaskManagerDB/save.htm?newtask=false"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	TASK ID: <form:input path="id"/>
	Content: <form:input path="content"/>
	<br/>
	Name: <form:input path="taskname"/>
	<br/>
	Category: <form:select path="categoryId" items="${OPTIONS}"></form:select>
	<br/>
	User: <form:select path="userSpringIdentifier" items="${USER_OPTIONS}"></form:select>
	<br/>
	Priority: <form:select path="prioritySpringIdentifier" items="${PRIORITY_OPTIONS}"></form:select>
	<br/>
	Status: <form:select path = "statusSpringIdentifier" items="${STATUS_OPTIONS}"></form:select>
	<input type="submit"/>
</form:form>



</body>
</html>