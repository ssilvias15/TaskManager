	<%@ include file="../page_components/header.jsp" %>

	

<h3>User information</h3>
Username: ${CURRENT_USER.username}<br/>
Password: ${CURRENT_USER.password}<br/>
<hr/>



<c:set var="thepath" value="/TaskManagerDB/users/profile"></c:set>


<form:form method="POST" action="${thepath}">
	<form:hidden path="id"/>
	Username: <form:input path="username"/><br/>
	Password: <form:input path="password"/><br/>
	<input type="submit"/ value="Edit profile data"/>
	
</form:form>
<%@ include file="../page_components/footer.jsp" %>