<%@ include file="../page_components/header_dashboard.jsp" %>

<h2>View all statuses</h2>
<div class="w3-border w3-round-xlarge">
  <h2>All Statuses</h2>
  <ul>
  <c:forEach items="${STATUSES}" var="status">
  	<li>${status.id} - ${status.statusname}</li>
  </c:forEach>
  </ul>
</div>
<%@ include file="../page_components/footer.jsp" %>