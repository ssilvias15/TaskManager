<%@ include file="page_components/header_dashboard.jsp" %>
<div class="page">
	<h2>Dashboard</h2>
	<%
		String userDeleted = request.getParameter("userdeleted");
		if (userDeleted != null) {
	%>
	<span style='color: #FF0000'>User has been successfully deleted</span>
	<%
		}
		String categoryDeleted = request.getParameter("categorydeleted");
		if (categoryDeleted != null) {
	%>
	<span style='color: #FF0000'>Category has been successfully
		deleted</span>
	<%
		}

		String priorityDeleted = request.getParameter("prioritydeleted");
		if (priorityDeleted != null) {
	%>
	<span style='color: #FF0000'>Priority has been successfully
		deleted</span>
	<%
		}
	%>

	<br />
	<h3>All users</h3>
	<br />
	<div class="table-condensive">
		<table class="table table-hover">
			<c:forEach items="${USERS}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td><a
						href="<%= request.getContextPath() %>/dashboard/edituser.htm?userid=${user.id}">Edit</a></td>
					<td><a
						href="<%= request.getContextPath() %>/dashboard/deleteuser.htm?userid=${user.id}"
						onclick="return confirm('Delete user ${user.username}');">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<a href="<%= request.getContextPath() %>/dashboard/adduser.htm">Add New User</a>

	<h3>All categories</h3>
	<br />
	<div class="table-condensive">
		<table class="table table-hover">
			<c:forEach items="${CATEGORIES}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.catname}</td>
					<td><a
						href="<%= request.getContextPath() %>/dashboard/editcategory.htm?categoryid=${category.id}">Edit</a></td>
					<td><a
						href="<%= request.getContextPath() %>/dashboard/deletecategory.htm?categoryid=${category.id}"
						onclick="return confirm('Delete category ${category.catname}');">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<a href="<%= request.getContextPath() %>/dashboard/addcategory.htm">Add
		New Category</a>

	<h3>All priorities</h3>
	<br />
	<div class="table-condensive">
		<table class="table table-hover">
			<c:forEach items="${PRIORITIES}" var="priority">
				<tr>
					<td>${priority.id}</td>
					<td>${priority.priorname}</td>
					<td><a
						href="<%= request.getContextPath() %>/dashboard/editpriority.htm?priorityid=${priority.id}">Edit</a></td>
					<td><a
						href="<%= request.getContextPath() %>/dashboard/deletepriority.htm?priorityid=${priority.id}"
						onclick="return confirm('Delete priority ${priority.priorname}');">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<a href="<%= request.getContextPath() %>/dashboard/addpriority.htm">Add New Priority</a>

	<h3>All statuses</h3>
	<br />
	<div class="table-condensive">
		<table class="table table-hover">
			<c:forEach items="${STATUSES}" var="status">
				<tr>
					<td>${status.id}</td>
					<td>${status.statusname}</td>
					<td><a
						href="<%= request.getContextPath() %>/dashboard/editstatus.htm?statusid=${status.id}">Edit</a></td>
					<td><a
						href="<%= request.getContextPath() %>/dashboard/deletestatus.htm?statusid=${status.id}"
						onclick="return confirm('Delete status ${status.statusname}');">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<a href="<%=request.getContextPath()%>/dashboard/addstatus.htm">Add New Status</a>
</div>
<%@ include file="page_components/footer.jsp" %>