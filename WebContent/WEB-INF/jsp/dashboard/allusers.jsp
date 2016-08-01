<%@ include file="../page_components/header_dashboard.jsp" %>
<h2>View all users</h2>
<div class="w3-border w3-round-xlarge">
  <h2>All users</h2>
  <ul>
  <c:forEach items="${USERS}" var="user">
  	<li>${user.id} - ${user.username} [ ${user.password} ] <a href="<%= request.getContextPath() %>/dashboard/edituser.htm?userid=${user.id}">Edit</a> <a href="<%= request.getContextPath() %>/dashboard/deleteuser.htm?userid=${user.id}" onclick="return confirm('Delete user ${user.username}');">Delete</a></li>
  </c:forEach>
  </ul>
</div>
<%@ include file="../page_components/footer.jsp" %>