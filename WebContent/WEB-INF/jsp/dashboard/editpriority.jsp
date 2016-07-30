<%@ include file="../page_components/header_dashboard.jsp" %>
<h2>EDIT PRIORITY</h2>


<!-- User add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/editpriority.htm"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	PRIORITY ID: <form:input path="id"/>
	Priority name: <form:input path="priorname"/>
	<br/>
	<input type="submit"/>
</form:form>

<%@ include file="../page_components/footer.jsp" %>