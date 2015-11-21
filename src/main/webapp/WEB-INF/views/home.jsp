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

	<div align="center">
	<form method="POST" action="./takeTest">
		<button class="btn btn-primary btn-lg" id="takeTestButton">
			Take a Test</button>
	</form>
	</div>
	



	<!-- javascript -->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/homeScript.js"></script>

</body>
</html>

