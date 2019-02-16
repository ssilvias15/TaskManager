<%@ include file="../page_components/header_dashboard.jsp" %>
<br/><h3>Edit category</h3><br/>
<c:set var="thepath" value="/TaskManagerDB/dashboard/editcategory.htm"></c:set>


<form:form method="POST" action="${thepath}">
	 <div class="form-group">Category ID<form:input class="form-control" path="id"/></div>
	 <div class="form-group">Category Name<form:input class="form-control" path="catname"/></div>
	<br/>
	<div class="form-group"> <input type="submit" class="btn btn-default"/></div>
</form:form>
<%@ include file="../page_components/footer.jsp" %>