<%@ include file="../page_components/header_dashboard.jsp" %>
<br/><h3>Add User</h3><br/>

<!-- User add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/adduser.htm"></c:set>

<form:form method="POST" action="${thepath}">
	<div class="form-group">Username<form:input class="form-control" path="username" />
	</div>
	
	<div class="form-group">Password<form:input class="form-control" path="password" />
	</div>
	<br/>
	
	<div class="form-group"><input type="submit" class="btn btn-default"/></div>
</form:form>


<%@ include file="../page_components/footer.jsp" %>