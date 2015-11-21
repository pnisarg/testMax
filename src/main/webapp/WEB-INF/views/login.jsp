<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/style.css">
        <title>Home</title>
    </head>
    <body>
     	<div class="container">
     		<div class="row">
     			<div class="col-md-3 col-xs-1 "></div>
	     		<div class="panel panel-success col-md-6 col-xs-10 login-panel">
		     		<div>
		     			<a href="./"><img src="resources/images/logo.png" class="img-responsive login-logo"></a>
		     		</div>
		     		 <label class="pull-right error" id="loginErrMsg">${message}</label>
		     		<div class="panel-body">
			     		<form class="form-signin" id="loginForm" method="POST" action="./login">
			     		   <label for="inputEmail"><span class="glyphicon glyphicon-user"></span> Username</label>
					       <input id="username" name="username" class="form-control" placeholder="Username" required pattern="[a-zA-Z0-9]+" autofocus>
					       <br>
					       <label for="inputPassword"><span class="glyphicon glyphicon-lock"></span> Password</label>
					       <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
					       <div class="checkbox">
					         <label>
					           <input type="checkbox" value="remember-me"> Remember me
					         </label>
					       </div>
					       <button class="btn btn-lg btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-log-in"></span> Sign in</button>
					     </form>
		     		</div>
	     	</div>
	     	<div class="col-md-3 col-xs-1"></div>
	     	</div> <!--  /row -->
     	</div> <!-- /container -->
		
	<!-- javascript -->	
		<script src="resources/js/jquery.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/jquery.validate.js"></script>
		<script src="resources/js/login.js"></script>

    </body>
</html>
