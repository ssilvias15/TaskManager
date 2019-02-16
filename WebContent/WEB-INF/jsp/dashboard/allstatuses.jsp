<%@ include file="../page_components/header_dashboard.jsp" %>

  <br/><h3>All Statuses</h3><br/>
  
	<div class="table-condensive">
		<table class="table table-hover">
			<c:forEach items="${STATUSES}" var="status">
				<tr>
					<td>${status.id}</td>
					<td>${status.statusname}</td>
					<td><a
						href="<%= request.getContextPath() %>/tasks/statuses/edit/${status.id}">Edit</a></td>
						<td><a
					href="<%= request.getContextPath() %>/dashboard/deletestatus.htm?statusid=${status.id}"
					onclick="return confirm('Delete status ${status.statusname}');">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@ include file="../page_components/footer.jsp" %>