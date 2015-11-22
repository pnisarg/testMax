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

	<div class="container">
		<div class="row homePagePanel well">
			
			<div class="col-md-12" id="questionContainer">
				<!-- <form action="./submitTest" method="POST"> -->
				<div class="questions" id="questionPanel">
					
				</div>
				<input type="hidden" id="hiddenqIdList" name="qIdList" value="">
				<div class="paging" align="center">
					<nav>
						<ul class="pagination">
							<li class="disabled"><a href="#" aria-label="Previous"> <span
									aria-hidden="true" class="diabaled">&laquo;</span>
							</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li class="disabled"><a href="#" aria-label="Next"> <span
									aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
				<div align="right">
					<button id="submitTest" class="btn btn-primary"><span class="glyphicon glyphicon-check"></span> Submit </button>
				</div>
				<!-- </form> -->
			</div>
			
		</div>
	</div>

	<!-- javascript -->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/questionPanel.js"></script>

</body>
</html>

