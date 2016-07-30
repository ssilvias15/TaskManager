<%@ include file="../page_components/header_dashboard.jsp" %>
<h2>Edit category</h2>
<c:set var="thepath" value="/TaskManagerDB/dashboard/editcategory.htm"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	Category ID: <form:input path="id"/>
	Category name: <form:input path="catname"/>
	<br/>
	<input type="submit"/>
</form:form>
<%@ include file="../page_components/footer.jsp" %>