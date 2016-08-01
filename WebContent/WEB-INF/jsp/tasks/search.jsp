
<%@ include file="../page_components/header.jsp"%>

<div class="w3-border w3-round-xlarge">
	<h2>Search results</h2>
	<c:choose>

		<c:when test="${empty TASKS}">
			<span style="color: #FF0000;">No matching results</span>
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${TASKS}" var="task">
					<li>${task.id}- ${task.content} <a
						href="<%= request.getContextPath() %>/tasks/viewtask/${task.id}">View</a>
						<a href="<%= request.getContextPath() %>/tasks/edit/${task.id}">Edit</a></li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>

</div>

<%@ include file="../page_components/footer.jsp"%>