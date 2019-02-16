<%@ include file="../page_components/header_dashboard.jsp" %>
<br/><h3>Add Status</h3><br/>


<c:set var="thepath" value="/TaskManagerDB/dashboard/addstatus.htm"></c:set>


<form:form method="POST" action="${thepath}">
	<div class="form-group">Status Name<form:input class="form-control" path="statusname"/></div>
	<br/>
	<br/>
	<div class="form-group"> <input type="submit" class="btn btn-default"/></div>
</form:form>

<%@ include file="../page_components/footer.jsp" %>

