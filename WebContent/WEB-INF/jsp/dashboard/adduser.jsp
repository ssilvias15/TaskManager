<%@ include file="../page_components/header_dashboard.jsp" %>
<h2>ADD USER</h2>

<!-- User add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/adduser.htm"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	Username: <form:input path="username"/>
	<br/>
	Password: <form:input path="password"/>
	<br/>
	<input type="submit"/>
</form:form>


<%@ include file="../page_components/footer.jsp" %>