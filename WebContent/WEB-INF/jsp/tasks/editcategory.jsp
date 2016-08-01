
<%@ include file="../page_components/header.jsp"%>

<h2>Edit Category</h2>


<c:set var="thepath" value="/TaskManagerDB/tasks/categories/edit/"></c:set>


<form:form method="POST" action="${thepath}">
	<form:hidden path="id" />
	Category Name: <form:input path="catname" />
	<input type="submit" />
</form:form>

<%@ include file="../page_components/footer.jsp"%>