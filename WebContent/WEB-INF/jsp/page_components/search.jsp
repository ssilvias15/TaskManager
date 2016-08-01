

<script>
	function search(searchTerm){
		window.location = "<%= request.getContextPath() %>/tasks/search?query="+searchTerm;
	}
	
	$(document).ready(function(){
		$('#searchButton').click(function(){
			search($('#input_search').val());
		});
		
	});
</script>

<li class="sidebar-search">
	<div class="input-group custom-search-form">
		<input type="text" id="input_search" class="form-control" placeholder="Search...">
		<span class="input-group-btn">
			<button class="btn btn-default" type="button" id="searchButton">
				<i class="fa fa-search"></i>
			</button>
		</span>
	</div> <!-- /input-group -->
</li>