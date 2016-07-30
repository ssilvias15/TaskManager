	<%@ include file="../page_components/header.jsp" %>

<h2>Add task</h2>


<c:set var="thepath" value="/TaskManagerDB/save.htm?newtask=false"></c:set>

PATH: ${thepath}

<form:form method="POST" action="${thepath}">
	TASK ID: <form:input path="id"/>
	Content: <form:input path="content"/>
	<br/>
	Name: <form:input path="taskname"/>
	<br/>
	Category: <form:select path="categoryId" items="${OPTIONS}"></form:select>
	<br/>
	User: <form:select path="userSpringIdentifier" items="${USER_OPTIONS}"></form:select>
	<br/>
	Priority: <form:select path="prioritySpringIdentifier" items="${PRIORITY_OPTIONS}"></form:select>
	<br/>
	Status: <form:select path = "statusSpringIdentifier" items="${STATUS_OPTIONS}"></form:select>
	<input type="submit"/>
</form:form>

	<%@ include file="../page_components/footer.jsp" %>