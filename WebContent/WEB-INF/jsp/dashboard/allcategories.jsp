	<%@ include file="../page_components/header_dashboard.jsp" %>


	<br/><h3>All Categories</h3><br/>

	<div class="table-condensive">
		<table class="table table-hover">
			<c:forEach items="${CATEGORIES}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.catname}</td>
					<td><a
						href="<%= request.getContextPath() %>/tasks/categories/edit/${category.id}">Edit</a></td>
					<td><a
					href="<%= request.getContextPath() %>/dashboard/deletecategory.htm?categoryid=${category.id}"
					onclick="return confirm('Delete category ${category.catname}');">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@ include file="../page_components/footer.jsp" %>