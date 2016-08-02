<%@ include file="../page_components/header_dashboard.jsp" %>

<!-- Category add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/addcategory.htm"></c:set>


<h3>Add Category</h3><br/>

<form:form method="POST" action="${thepath}">
	<div class="form-group">
		Category name
		<form:input class="form-control" path="catname" />
	</div>
	<br />
	<div class="form-group">
		<input type="submit" class="btn btn-default" />
	</div>
</form:form>

<%@ include file="../page_components/footer.jsp" %>