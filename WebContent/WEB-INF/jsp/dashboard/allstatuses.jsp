<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="../libs.jsp" %>
<title>All Statuses</title>

</head>
<body>
<!-- navbar goes here -->
<%@ include file="../navbar_dashboard.jsp" %>

<h2>View all statuses</h2>
<div class="w3-border w3-round-xlarge">
  <h2>All Statuses</h2>
  <ul>
  <c:forEach items="${STATUSES}" var="status">
  	<li>${status.id} - ${status.statusname}</li>
  </c:forEach>
  </ul>
</div>
</body>
</html>