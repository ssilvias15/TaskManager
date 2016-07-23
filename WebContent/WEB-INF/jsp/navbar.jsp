<nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              	<li class="menu-item"><a class="activePage" href="<%= request.getContextPath() %>/index.htm">Home</a></li>
			  	<li class="menu-item"><a href="<%= request.getContextPath() %>/mytasks.htm">My Tasks</a></li>
			  	<li class="menu-item"><a href="<%= request.getContextPath() %>/alltasks.htm">All Tasks</a></li>
			  	<li class="menu-item"><a href="<%= request.getContextPath() %>/create.htm">Create</a></li>
			  	<li class="menu-item"><a href="<%= request.getContextPath() %>/myprofile.htm">My profile</a></li>
			  	<li class="menu-item"><a href="<%= request.getContextPath() %>/dashboard/dashboard.htm">Dashboard</a></li>
			  	<li class="menu-item"><a href="<%= request.getContextPath() %>/logout">Logout</a></li>
            </ul>
          </div>
        </div>
</nav>