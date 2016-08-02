	<%@ include file="../page_components/header.jsp" %>

<h3>Edit Task</h3>


<c:set var="thepath" value="/TaskManagerDB/save.htm?newtask=false"></c:set>


<form:form method="POST" action="${thepath}">
	<div class="form-group">
	
	  	<br/>
		<div class="form-group">Number<form:input class="form-control" id="taskid" path="id"/></div>
		<br/>
		
		<div class="form-group">Name<form:input class="form-control" id="taskname" path="taskname"/></div>
		<br/>
		
		<div class="form-group">Content<form:input class="form-control" id="taskcontent" path="content"/></div>
		<br/>
		
		<div class="form-group">Assignee <form:select class="form-control" id="taskuser" path="userSpringIdentifier" items="${USER_OPTIONS}"></form:select></div>
		<br/>
		
		
		<div class="form-group">Category <form:select class="form-control" id="taskcategory" path="categoryId" items="${OPTIONS}"></form:select></div>
		<br/>
		
		
		<div class="form-group">Priority <form:select class="form-control" id="taskpriority" path="prioritySpringIdentifier" items="${PRIORITY_OPTIONS}"></form:select></div>
		<br/>
		
		<div class="form-group">Status <form:select class="form-control" id="taskstatus" path = "statusSpringIdentifier" items="${STATUS_OPTIONS}"></form:select></div>
		<br/>
		
		<div class="form-group"> <input type="submit" class="btn btn-default"/></div>
 </div>
</form:form>


	<%@ include file="../page_components/footer.jsp" %>