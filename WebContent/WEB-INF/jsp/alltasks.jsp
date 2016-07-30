	<%@ include file="page_components/header.jsp" %>
<div class="w3-border w3-round-xlarge">
  <h2>All tasks</h2>
</div>

<div class="w3-border w3-round-xlarge">
  <h2>All tasks</h2>
  <ul>
  <c:forEach items="${TASKS}" var="task">
  	<li>${task.id} - ${task.content} <a href="<%= request.getContextPath() %>/tasks/viewtask/${task.id}">View</a> <a href="<%= request.getContextPath() %>/tasks/edit/${task.id}">Edit</a></li>
  </c:forEach>
  </ul>
</div>

	<%@ include file="page_components/footer.jsp" %>