<%@ include file="../page_components/header_dashboard.jsp" %>
<h2>ADD STATUS</h2>

<!-- User add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/addstatus.htm"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	Status name: <form:input path="statusname"/>
	<br/>
	<br/>
	<input type="submit"/>
</form:form>

<%@ include file="../page_components/footer.jsp" %>