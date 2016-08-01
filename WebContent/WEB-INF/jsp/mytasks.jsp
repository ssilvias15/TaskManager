
<%@ page import="ie.silvia.model.Users"%>

	<%@ include file="page_components/header.jsp" %>
<title>My tasks</title>
</head>
<body>
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
	
	<form action="<%= request.getContextPath() %>/mytasks.htm">
		<select name="filterPriority">
			<c:forEach items="${PRIORITIES}" var = "priority">
				<option value="${priority.id}">${priority.priorname}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Select Priority"/>
	</form>
	<%@ include file="page_components/footer.jsp" %>