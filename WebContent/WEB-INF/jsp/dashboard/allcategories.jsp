	<%@ include file="../page_components/header_dashboard.jsp" %>
<div class="w3-border w3-round-xlarge">
  <h2>All tasks</h2>
</div>

<div class="w3-border w3-round-xlarge">
  <h2>All users</h2>
  <ul>
  <c:forEach items="${CATEGORIES}" var="category">
  	<li>${category.id} - ${category.catname} <a href="<%= request.getContextPath() %>/tasks/categories/edit/${category.id}">Edit</a></li>
  </c:forEach>
  </ul>
</div>

	<%@ include file="../page_components/footer.jsp" %>