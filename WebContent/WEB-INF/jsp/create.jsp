	<%@ include file="page_components/header.jsp" %>

<h2>Add task</h2>

<c:set var="thepath" value="/TaskManagerDB/save.htm?newtask=true"></c:set>


<form:form method="POST" action="${thepath}" role="form">
  <div class="form-group">
  	<br/>
	<label for="taskname"> Name </label><form:input class="form-control" id="taskname" path="taskname"/>
	<br/>
	
  <label for="content">Content</label>  <form:textarea class="form-control" path="content" rows="4" cols="30"/>
	</div>

<div class="form-group"> Assignee <form:select class="form-control" path="userSpringIdentifier" items="${USER_OPTIONS}"></form:select>
	<br/>
	</div>
	
	 <div class="form-group"> Category  <form:select  class="form-control" path="categoryId" items="${OPTIONS}"></form:select>
	</div>
	<br/>
	
	 <div class="form-group">Priority <form:select class="form-control" path="prioritySpringIdentifier" items="${PRIORITY_OPTIONS}"></form:select>
	</div>
	<br/>
	<div class="form-group">Status <form:select class="form-control" path = "statusSpringIdentifier" items="${STATUS_OPTIONS}"></form:select>
	</div>
	
	 <div class="form-group"> <input type="submit" class="btn btn-default"/>
	</div>
</form:form>

	<%@ include file="page_components/footer.jsp" %>