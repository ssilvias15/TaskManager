	<%@ include file="../page_components/header.jsp" %>

<h2>Edit Task</h2>


<c:set var="thepath" value="/TaskManagerDB/save.htm?newtask=false"></c:set>

<div class="form-group">
<form:form method="POST" action="${thepath}">

  	<br/>
	<label for="taskid">Number<form:input class="form-control" id="taskid" path="id"/></label>
	<br/>
	
	<label for="taskname">Name<form:input class="form-control" id="taskname" path="taskname"/></label>
	<br/>
	
	<label for="taskcontent">Content<form:input class="form-control" id="taskcontent" path="content"/></label>
	<br/>
	
	<label for="taskuser">Assignee <form:select class="form-control" id="taskuser" path="userSpringIdentifier" items="${USER_OPTIONS}"></form:select></label>
	<br/>
	
	
	<label for="taskcategory">Category <form:select class="form-control" id="taskcategory" path="categoryId" items="${OPTIONS}"></form:select></label>
	<br/>
	
	
	<label for="taskpriority">Priority <form:select class="form-control" id="taskpriority" path="prioritySpringIdentifier" items="${PRIORITY_OPTIONS}"></form:select></label>
	<br/>
	
	<label for="taskstatus">Status <form:select class="form-control" id="taskstatus" path = "statusSpringIdentifier" items="${STATUS_OPTIONS}"></form:select></label>
	<br/>
	
	<input type="submit"/>
</form:form>
</div>

	<%@ include file="../page_components/footer.jsp" %>