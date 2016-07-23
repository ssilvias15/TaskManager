<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<%@ include file="../libs.jsp" %>
    
	<title>MultiTask</title>
</head>


<body>
<!-- navbar goes here -->
<%@ include file="../navbar.jsp" %>

<article class="container-body reg-form">   
<div class="page">

<div class="w3-border w3-round-xlarge">
  <h2>View task</h2>
  Title: ${TASK.taskname}<br/>
  
  Assigned to user: ${TASK.userid.username} <br/>
  <hr/>
  Priority: ${TASK.priorityid.priorname}<br/>
  Category: ${TASK.catid.catname}<br/>
  Status: ${TASK.statusid.statusname}<br/>
  Content: ${TASK.content} </br>
  
  <a href="">Add attachment</a>
  <hr/>

</div>


</div>
</article>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   <script src="resources/js/bootstrap.min.js"></script>
   <script src="resources/js/heading.js"></script>

</body>
</html>