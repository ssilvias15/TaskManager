<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="ie.silvia.model.upload.UploadService"%>
<%@ page import="ie.silvia.model.Tasks"%>
<%@ page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="../libs.jsp"%>

<title>MultiTask</title>
</head>


<body>
	<!-- navbar goes here -->
	<%@ include file="../navbar.jsp"%>

	<article class="container-body reg-form">
	<div class="page">

		<div class="w3-border w3-round-xlarge">
			<h2>View task</h2>
			<a href="<%= request.getContextPath() %>/tasks/edit/${TASK.id}">Edit</a><br/><br/>
			Title: ${TASK.taskname}<br /> Assigned to user:
			${TASK.userid.username} <br />
			<hr />
			Priority: ${TASK.priorityid.priorname}<br /> Category:
			${TASK.catid.catname}<br /> Status: ${TASK.statusid.statusname}<br />
			Content: ${TASK.content} </br>


			<hr/>
			
			<!-- Spring upload form -->

			<c:set var="thepath" value="/TaskManagerDB/singleUpload?taskid="></c:set>
			<form:form method="POST" action="${thepath}" 
				modelAttribute="fileBucket" enctype="multipart/form-data"
				class="form-horizontal">

				<form:hidden path="taskId" />

				<div class="row">

					<div class="form-group col-md-12">

						<label class="col-md-3 control-lable" for="file">Upload a
							file</label>

						<div class="col-md-7">

							<form:input type="file" path="file" id="file"
								class="form-control input-sm" />

							<div class="has-error"></div>

						</div>

					</div>

				</div>



				<div class="row">

					<div class="form-actions floatRight">

						<input type="submit" value="Upload" class="btn btn-primary btn-sm">

					</div>

				</div>

			</form:form>
			<!-- /Spring upload form -->
			<hr />
			<h2>Attachments</h2>
			<%
				Tasks task = (Tasks) request.getAttribute("TASK");				
				out.println("CURRENT TASK ID: " + task.getId());
				List<String> attachmentNames = UploadService.getFilesInTaskDirectory(task.getId());

				if (attachmentNames.size() == 0) {
			%>
				<span style="color: #0000FF;">No attachments</span>
			<%
				} else {

					out.println("<ul>");
					for (String attachmentName : attachmentNames) {
						out.println("<li><a href='"+request.getContextPath()+"/files/"+task.getId()+"/"+attachmentName+"'>"+attachmentName+"</a></li>");
					}
					out.println("<ul>");
				}
			%>

		</div>


	</div>
	</article>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/heading.js"></script>

	<hr />
			<c:set var="thepathVT" value="/TaskManagerDB/tasks/viewtask"></c:set>
			<form:form method="POST" action="${thepathVT}" 
				
				class="form-horizontal">
				<form:hidden path="springTaskId" />
				COMMENT: <form:input path="commenttext"/> <br/>
				<input type="submit" value = "save comment"/>
			</form:form>
			
			<hr/>
			
		<!-- Iterate through each comment associated with the task in order to display them -->
		<ul>	
		<c:forEach items="${TASK.commentsList}" var="comment">
			<li>${comment.commenttext}</li>
		</c:forEach>
		</ul>
</body>
</html>