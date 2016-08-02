

	<%@ include file="page_components/header.jsp" %>
    

<h3>Very Recent Tasks</h3><br/>

<div class="table-condensive">
	<table class="table table-hover">
 	 		<c:forEach items="${TASKS}" var="task">
 	 		<tr>
				<td>${task.id}</td>
				<td>${task.taskname}</td>
			 	<td><a href="<%= request.getContextPath() %>/tasks/viewtask/${task.id}">View</a> </td>
			 	<td><a href="<%= request.getContextPath() %>/tasks/edit/${task.id}">Edit</a></td>
			 </tr>
  			</c:forEach>
	</table>
</div>
<br/>

<h3>Most Recent Comments To My Tasks</h3></br>
<div class="table-condensive">
	<table class="table table-hover">
			<c:forEach items="${RECENT_COMMENTS}" var = "comment">
			<tr>
				<td>${comment.commenttext}</td>
				<td> <a href="<%= request.getContextPath() %>/tasks/viewtask/${comment.taskid.id}">View Task ${comment.taskid.taskname}</a></td>
			 </tr>
  			</c:forEach>
	</table>
</div>

<%@ include file="page_components/footer.jsp" %>