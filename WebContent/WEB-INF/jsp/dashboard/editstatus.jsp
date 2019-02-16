<%@ include file="../page_components/header_dashboard.jsp" %>
<br/><h3>Edit Status</h3><br/>


<c:set var="thepath" value="/TaskManagerDB/dashboard/editstatus.htm"></c:set>

<form:form method="POST" action="${thepath}">
	<div class="form-group">Status ID<form:input class="form-control" path="id"/></div>
	<div class="form-group">Status Name <form:input class="form-control" path="statusname"/></div>
	<br/>
	<div class="form-group"> <input type="submit" class="btn btn-default"/></div>
</form:form>

<%@ include file="../page_components/footer.jsp" %>

