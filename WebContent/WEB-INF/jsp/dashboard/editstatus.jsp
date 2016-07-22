<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Status</title>
</head>
<body>
<h2>EDIT STATUS</h2>


<!-- Status add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/editstatus.htm"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	Status ID: <form:input path="id"/>
	Status name: <form:input path="statusname"/>
	<br/>
	<input type="submit"/>
</form:form>


</body>
</html>