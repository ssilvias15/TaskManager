
<%@ page import="ie.silvia.model.upload.UploadService"%>
<%@ page import="ie.silvia.model.Tasks"%>
<%@ page import="java.util.List"%>

	<%@ include file="../page_components/header.jsp" %>

			<h3>View Task</h3>
			
			<a href="<%= request.getContextPath() %>/tasks/edit/${TASK.id}">Edit</a><br/><br/>

<div class="table-condensive">
	<table class="table table-hover">
		<tr>
			<td>Task Name</td>
			<td>${TASK.taskname}</td>
		</tr>
		<tr>
			<td>Assignee </td><td>${TASK.userid.username}</td>
		</tr>
		<tr>
			<td>Priority</td> <td>${TASK.priorityid.priorname}</td>
		</tr>
		<tr>
			<td>Category</td> <td>${TASK.catid.catname}</td>
		</tr>
		<tr>
			<td>Status</td> <td>${TASK.statusid.statusname}</td>
		</tr>
		<tr>
			<td>Content</td> <td>${TASK.content}</td>
		</tr>
	</table>
</div>

<hr/>
			<br/><h3>Attachments</h3><br/>
			
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
			
			<%
				Tasks task = (Tasks) request.getAttribute("TASK");				
				out.println("Current Task Number: \n" + task.getId()); 
				List<String> attachmentNames = UploadService.getFilesInTaskDirectory(task.getId());

				if (attachmentNames.size() == 0) {
			%>
				<span style="color: #0000FF;">: No attachments for this task</span>
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




	<hr /><br/>
	<h3>Comments</h3><br/>
			<c:set var="thepathVT" value="/TaskManagerDB/tasks/viewtask"></c:set>
			<form:form method="POST" action="${thepathVT}" 
				
				class="form-horizontal">
				<form:hidden path="springTaskId" />
				<br/>Add Comment <form:input path="commenttext"/> <br/><br/>
				<input type="submit" value = "Save Comment"/>
			</form:form>
			
			<hr/>
			
		<!-- Iterate through each comment associated with the task in order to display them -->
		<ul>	
		<c:forEach items="${TASK.commentsList}" var="comment">
			<li>${comment.commenttext}</li>
		</c:forEach>
		</ul>
	<%@ include file="../page_components/footer.jsp" %>