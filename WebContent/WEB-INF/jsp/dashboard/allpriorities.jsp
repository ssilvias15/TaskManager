<%@ include file="../page_components/header_dashboard.jsp" %>

<h2>View all priorities</h2>
<div class="w3-border w3-round-xlarge">
  <h2>All Statuses</h2>
  <ul>
  <c:forEach items="${PRIORITIES}" var="priority">
  	<li>${priority.id} - ${priority.priorname} <a href="<%= request.getContextPath() %>/tasks/priorities/edit/${priority.id}">Edit</a></li>
  </c:forEach>
  </ul>
</div>
<%@ include file="../page_components/footer.jsp" %>