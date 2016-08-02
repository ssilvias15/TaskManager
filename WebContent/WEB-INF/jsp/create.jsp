	<%@ include file="page_components/header.jsp" %>

<h2>Add task</h2>

<c:set var="thepath" value="/TaskManagerDB/save.htm?newtask=true"></c:set>




<form:form method="POST" action="${thepath}" role="form">
  <div class="form-group">
  <label for="content">CONTENT</label><form:input class="form-control" path="content"/>
	</div>
	<br/>
	<label for="taskname"> Name: </label><form:input class="form-control" id="taskname" path="taskname"/>
	<br/>
	 <div class="form-group">
	<label for="catsel"> Category Name: </label>
	<form:select path="categoryId" items="${OPTIONS}" id="catsel"></form:select>
	</div>
	<br/>
	 <div class="form-group">
	User: <form:select class="form-control" path="userSpringIdentifier" items="${USER_OPTIONS}"></form:select>
	<br/>
	</div>
	 <div class="form-group">
	Priority: <form:select class="form-control" path="prioritySpringIdentifier" items="${PRIORITY_OPTIONS}"></form:select>
	<br/>
	Status: <form:select class="form-control" path = "statusSpringIdentifier" items="${STATUS_OPTIONS}"></form:select>
	</div>
	 <div class="form-group">
	<input type="submit" class="btn btn-default"/>
	</div>
</form:form>
	<%@ include file="page_components/footer.jsp" %>