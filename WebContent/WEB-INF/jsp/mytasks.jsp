
<%@ page import="ie.silvia.model.Users"%>

	<%@ include file="page_components/header.jsp" %>
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
	<%@ include file="page_components/footer.jsp" %>