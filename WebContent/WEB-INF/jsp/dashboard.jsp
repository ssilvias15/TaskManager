<%@ include file="page_components/header_dashboard.jsp" %>
<div class="page">
	<h2>Dashboard</h2>
	<%
		String userDeleted = request.getParameter("userdeleted");
		if(userDeleted != null){
			%>
			<span style='color: #FF0000'>User has been successfully deleted</span>
			<%
		}
		String categoryDeleted = request.getParameter("categorydeleted");
		if(categoryDeleted != null){
			%>
			<span style='color: #FF0000'>Category has been successfully deleted</span>
			<%
		}
		
		String priorityDeleted = request.getParameter("prioritydeleted");
		if(priorityDeleted != null){
			%>
			<span style='color: #FF0000'>Priority has been successfully deleted</span>
			<%
		}
		
	%>
	
	 <h2>All users</h2>
  <ul>
  <c:forEach items="${USERS}" var="user">
  	<li> ${user.id} ${user.username} [ ${user.password} ] <a href="<%= request.getContextPath() %>/dashboard/edituser.htm?userid=${user.id}">Edit</a> <a href="<%= request.getContextPath() %>/dashboard/deleteuser.htm?userid=${user.id}" onclick="return confirm('Delete user ${user.username}');">Delete</a></li>
  </c:forEach>
  </ul>
  
  <h2>All categories</h2>
    <ul>
  <c:forEach items="${CATEGORIES}" var="category">
  	<li>${category.id} : ${category.catname} <a href="<%= request.getContextPath() %>/dashboard/editcategory.htm?categoryid=${category.id}">Edit</a> <a href="<%= request.getContextPath() %>/dashboard/deletecategory.htm?categoryid=${category.id}" onclick="return confirm('Delete category ${category.catname}');">Delete</a></li>
  </c:forEach>
  </ul>
  <a href="<%= request.getContextPath() %>/dashboard/addcategory.htm">Add New Category</a>
  
  <h2>All priorities</h2>
  <ul>
  	
  	<c:forEach items="${PRIORITIES}" var="priority">
  		<li> ${priority.id} - ${priority.priorname}  <a href="<%= request.getContextPath() %>/dashboard/editpriority.htm?priorityid=${priority.id}">Edit</a> <a href="<%= request.getContextPath() %>/dashboard/deletepriority.htm?priorityid=${priority.id}" onclick="return confirm('Delete priority ${priority.priorname}');">Delete</a></li> 
  	</c:forEach>
  </ul>
   <a href="<%= request.getContextPath() %>/dashboard/addpriority.htm">Add New Priority</a>
   
     <h2>All statuses</h2>
  <ul>
  	
  	<c:forEach items="${STATUSES}" var="status">
  		<li>${status.id} - ${status.statusname}  <a href="<%= request.getContextPath() %>/dashboard/editstatus.htm?statusid=${status.id}">Edit</a> <a href="<%= request.getContextPath() %>/dashboard/deletestatus.htm?statusid=${status.id}" onclick="return confirm('Delete status ${status.statusname}');">Delete</a></li> 
  	</c:forEach>
  </ul>
   <a href="<%= request.getContextPath() %>/dashboard/addstatus.htm">Add New Status</a>
</div>
<%@ include file="page_components/footer.jsp" %>