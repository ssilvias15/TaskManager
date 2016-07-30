<%@ include file="../page_components/header_dashboard.jsp" %>
<h2>EDIT STATUS</h2>


<!-- Status add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/editstatus.htm"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	Status ID: <form:input path="id"/>
	Status name: <form:input path="statusname"/>
	<br/>
	<input type="submit"/>
</form:form>

<%@ include file="../page_components/footer.jsp" %>