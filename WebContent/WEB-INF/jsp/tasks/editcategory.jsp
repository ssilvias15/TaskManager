
<%@ include file="../page_components/header.jsp"%>

<h3>Edit Category</h3><br/>


<c:set var="thepath" value="/TaskManagerDB/tasks/categories/edit/"></c:set>


<form:form method="POST" action="${thepath}">
	<form:hidden path="id" />
	 <div class="form-group">Category Name<form:input class="form-control" path="catname" /></div><br/>
	<div class="form-group"> <input type="submit" class="btn btn-default"/></div>
</form:form>

<%@ include file="../page_components/footer.jsp"%>