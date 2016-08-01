
<%@ include file="../page_components/header.jsp"%>

<h2>Edit Priority</h2>


<c:set var="thepath" value="/TaskManagerDB/tasks/priorities/edit/"></c:set>


<form:form method="POST" action="${thepath}">
	<form:hidden path="id" />
	Priority Name: <form:input path="priorname" />
	<input type="submit" />
</form:form>

<%@ include file="../page_components/footer.jsp"%>