<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Upload attachment</h2>
	
	<c:set var="thepath" value="/TaskManagerDB/uploadfile.htm"></c:set>
	<form:form method="POST" commandName="file" action="${thepath}"
		enctype="multipart/form-data">

 

		Upload your file please: 

		<input type="file" name="file" />

		<input type="submit" value="upload" />

		<form:errors path="file" cssStyle="color: #ff0000;" />

	</form:form>
</body>
</html>