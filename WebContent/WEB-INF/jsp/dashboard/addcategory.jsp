<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Category</title>
</head>
<body>

<!-- Category add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/addcategory.htm"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	Category name: <form:input path="catname"/>
	<br/>
	<input type="submit"/>
</form:form>


</body>
</html>