<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<title>testMax</title>
</head>
<body>

	<div class="row">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#collapse">
						<span class="sr-only">Toggle Navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"><img
						src="resources/images/logo_home.png"
						class="img-responsive nav-logo"></a>
				</div>

				<div class="collapse navbar-collapse" id="collapse">
					<div class="nav navbar-nav navbar-right">
						<div class="navbar-text pull-right">
							Welcome,
							<%=session.getAttribute("fname").toString() + " "
					+ session.getAttribute("lname").toString()%>
							<br> <a href="./logout" class="navbar-link pull-right">
								Logout <span class="glyphicon glyphicon-off"> </span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</nav>
	</div>
	<!-- End of Row 1 navbar -->

	<div class="adminPanel" align="center">
		<button class="btn btn-default btn-lg" data-toggle="modal" data-target="#myModal">Upload
			Questions</button>
	</div>

	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Upload Question</h4>
				</div>
				<div class="modal-body">
					<form class="form-signin" method="POST" action="./question">
			     		   <label for="questionString"><span class="glyphicon glyphicon-question-sign"></span> Question</label>
					       <textarea rows="3" name="question" class="form-control" placeholder="Quesstion String.." required autofocus></textarea>
					       <br>
					       <label for="optionsList"><span class="glyphicon glyphicon-th-list"></span> Option List</label>
					       <textarea name="optionsList"  class="form-control" rows="6" placeholder="Enter options seperated by '|' (pipe character)"  required></textarea>
					       <br>
					       <label for="correctVal"><span class="glyphicon glyphicon-th-list"></span> Correct Answer</label>
					       <input type="text" name="correctVal" class="form-control" placeholder="Correct Answer (a/b/c/d etc)" maxlength="1" required>
					       <br>
					       <label for="course"><span class="glyphicon glyphicon-th-list"></span> Course</label>
					       <!-- Some random course! This can be made dynamic-->
					       <select name="course">
					       		<option value="history">History</option>
					       		<option value="economics">Economics</option>
					       		<option value="accounts">Accounts</option>
					       		<option value="law">Law</option>
					       </select>
					       <br>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-danger">Save
									Changes</button>
							</div>
						</form>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- End of Row 2 body -->

	<!-- javascript -->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>

</body>
</html>

