<%@ include file="../page_components/header_dashboard.jsp" %>
<br/><h3>Edit Priority</h3><br/>

<c:set var="thepath" value="/TaskManagerDB/dashboard/editpriority.htm"></c:set>

<form:form method="POST" action="${thepath}">
	<div class="form-group">Priority ID<form:input class="form-control" path="id"/></div>
	<div class="form-group">Priority Name: <form:input class="form-control" path="priorname"/></div>
	<br/>
	<div class="form-group"> <input type="submit" class="btn btn-default"/></div>
</form:form>

<%@ include file="../page_components/footer.jsp" %>