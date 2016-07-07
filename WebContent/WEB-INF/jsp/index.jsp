<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
 	<link rel="stylesheet" type="text/css" href="css/reset-stylesheet.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    
	<title>MultiTask</title>
</head>

<body>

<body>
<nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              	<li class="menu-item"><a class="activePage" href="index.html">Home</a></li>
			  	<li class="menu-item"><a href="mytasks.html">My Tasks</a></li>
			  	<li class="menu-item"><a href="alltasks.html">All Tasks</a></li>
			  	<li class="menu-item"><a href="create.html">Create</a></li>
			  	<li class="menu-item"><a href="myprofile.html">My profile</a></li>
            </ul>
          </div>
        </div>
      </nav>


<article class="container-body reg-form">   
<div class="page">

<div class="w3-border w3-round-xlarge">
  <h2>My tasks</h2>
</div>

<div class="w3-border w3-round-xlarge">
  <h2>Recent tasks</h2>
  <ul>
  <c:forEach items="${TASKS}" var="task">
  	<li>${task.id} - ${task.content}</li>
  </c:forEach>
  </ul>
</div>


</div>
</article>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/heading.js"></script>

</body>
</html>