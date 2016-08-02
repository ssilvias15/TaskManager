	<%@ include file="../page_components/header.jsp" %>


<br/><br/><h3>My Recent Tasks</h3><br/><br/>
  
<div class="table-condensive">
	<table class="table table-hover">
  		<c:forEach items="${TASKS}" var="task">
  		<tr>
			<td>${task.id}</td>
			<td>${task.taskname}</td>
			<td><a href="<%= request.getContextPath() %>/tasks/viewtask/${task.id}">View</a></td>
			<td><a href="<%= request.getContextPath() %>/tasks/edit/${task.id}">Edit</a></td>
		</tr>
  		</c:forEach>
	</table>
</div>
	<%@ include file="../page_components/footer.jsp" %>
	
