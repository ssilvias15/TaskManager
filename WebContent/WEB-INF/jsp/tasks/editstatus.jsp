
<%@ include file="../page_components/header.jsp"%>

<h2>Edit Status</h2>


<c:set var="thepath" value="/TaskManagerDB/tasks/statuses/edit/"></c:set>


<form:form method="POST" action="${thepath}">
	<form:hidden path="id" />
	Status Name: <form:input path="statusname" />
	<input type="submit" />
</form:form>

<%@ include file="../page_components/footer.jsp"%>