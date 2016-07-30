<%@ include file="../page_components/header_dashboard.jsp" %>
<h2>EDIT USER</h2>

EDITING USER: ${USER_ID}<br/><br/>

<!-- User add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/edituser.htm"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	User ID: <form:input path="id"/>
	Username: <form:input path="username"/>
	<br/>
	Password: <form:input path="password"/>
	<br/>
	<input type="submit"/>
</form:form>

<%@ include file="../page_components/footer.jsp" %>