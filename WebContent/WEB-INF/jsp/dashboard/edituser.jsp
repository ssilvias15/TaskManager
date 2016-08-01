<%@ include file="../page_components/header_dashboard.jsp" %>
<h2>EDIT USER</h2>

EDITING USER: ${USER_ID}<br/><br/>

<!-- User add form -->
<c:set var="thepath" value="/TaskManagerDB/dashboard/edituser.htm"></c:set>


<form:form method="POST" action="${thepath}">
	User ID: <form:input path="id"/><br/>
	Username: <form:input path="username"/>
	<br/>
	Password: <form:input path="password"/>
	<br/>
	<input type="submit"/>
</form:form>


  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" id="email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd">
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>

<%@ include file="../page_components/footer.jsp" %>