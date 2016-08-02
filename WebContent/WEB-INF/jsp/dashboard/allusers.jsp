<%@ include file="../page_components/header_dashboard.jsp" %>

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
<%@ include file="../page_components/footer.jsp" %>