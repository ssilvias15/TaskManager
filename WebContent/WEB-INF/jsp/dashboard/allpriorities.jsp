<%@ include file="../page_components/header_dashboard.jsp" %>


  <br/><h3>All Priorities</h3><br/>

<div class="table-condensive">
	<table class="table table-hover">
		<c:forEach items="${PRIORITIES}" var="priority">
			<tr>
				<td>${priority.id}</td>
				<td>${priority.priorname}</td>
				<td><a
					href="<%= request.getContextPath() %>/tasks/priorities/edit/${priority.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</div>


<%@ include file="../page_components/footer.jsp" %>