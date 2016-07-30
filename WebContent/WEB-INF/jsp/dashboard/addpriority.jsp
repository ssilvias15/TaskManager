<%@ include file="../page_components/header_dashboard.jsp" %>
<h2>ADD PRIORITY</h2>

<!-- User add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/addpriority.htm"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	Priority name: <form:input path="priorname"/>
	<br/>
	<br/>
	<input type="submit"/>
</form:form>

<%@ include file="../page_components/footer.jsp" %>