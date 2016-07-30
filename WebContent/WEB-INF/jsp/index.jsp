

	<%@ include file="page_components/header.jsp" %>
    

 
<div class="page">


<div class="w3-border w3-round-xlarge">
  <h2>Recent tasks</h2>
  <ul class="tasks_list">
  <c:forEach items="${TASKS}" var="task">
  	<li>${task.id} - ${task.content} <a href="<%= request.getContextPath() %>/tasks/viewtask/${task.id}">View</a>  <a href="<%= request.getContextPath() %>/tasks/edit/${task.id}">Edit</a></li>
  </c:forEach>
  </ul>
</div>

<h2>Most recent comments to my tasks</h2>
<ul>
	
	<c:forEach items="${RECENT_COMMENTS}" var = "comment">
		<li>${comment.commenttext} <a href="<%= request.getContextPath() %>/tasks/viewtask/${comment.taskid.id}">View ${comment.taskid.taskname}</a></li>
	</c:forEach>
</ul>

</div>

<%@ include file="page_components/footer.jsp" %>