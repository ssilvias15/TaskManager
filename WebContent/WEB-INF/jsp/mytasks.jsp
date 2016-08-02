
<%@ page import="ie.silvia.model.Users"%>

	<%@ include file="page_components/header.jsp" %>
<title>My tasks</title>
</head>
<body>
	<h3>My current tasks</h3><br/>
	<%
		Users user = (Users)request.getAttribute("CURRENT_USER");
		out.println("USER: " + user.getUsername() + " " + user.getId()+"<br/>");
	%>
	<hr/>

	<div class="table-condensive">
		<table class="table table-hover">
			<c:forEach items="${MY_TASKS}" var="task">
				<tr>
					<td>${task.id}</td>
					<td>${task.taskname}</td>
					<td>status</td>
					<td>${task.statusid.statusname}</td>
					<td><a
						href="<%= request.getContextPath() %>/tasks/viewtask/${task.id}">View</a></td>
					<td><a
						href="<%= request.getContextPath() %>/tasks/edit/${task.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>



	<form action="<%= request.getContextPath() %>/mytasks.htm">
		<select name="filterPriority">
			<c:forEach items="${PRIORITIES}" var = "priority">
				<option value="${priority.id}">${priority.priorname}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Select Priority"/>
	</form>
	<%@ include file="page_components/footer.jsp" %>