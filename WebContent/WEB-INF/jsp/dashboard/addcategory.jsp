<%@ include file="../page_components/header_dashboard.jsp" %>

<!-- Category add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/addcategory.htm"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	Category name: <form:input path="catname"/>
	<br/>
	<input type="submit"/>
</form:form>

<%@ include file="../page_components/footer.jsp" %>