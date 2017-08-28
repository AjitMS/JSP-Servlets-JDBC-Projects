<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Register</title>

<!-- Bootstrap References -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

<!-- JQuery References  -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="CSS/register.css" />

</head>
<body>
	<div class="container justify-content-center col-xl-3 col-lg-6 col-md-8 col-sm-10" align="center"
		id="container">
		<div class="row">
			<div class="col">
				<h2 class="border">Create an account</h2>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col form-padding " align="left">
				<form action="LibraryRegistration" method="post">
					<label for="email">Full Name </label> <input type="fullname"
						class="form-control" id="fullname" placeholder="Enter full name"
						name="fullname"> <br> <label for="email">Email
						Address </label> <input type="email" class="form-control" id="email"
						placeholder="Enter email" name="email"> <br> <label
						for="phone">Phone number </label> <input type="tel"
						class="form-control" id="phone" placeholder="Enter mobile number"
						name="phone"> <br> <label for="password">Password</label>
					<input type="password" class="form-control" id="password"
						placeholder="Enter password" name="password"> <br> <label
						for="password">Confirm Password</label> <input type="password"
						class="form-control" id="password" placeholder="Repeat password"
						name="password"> <br> <label for="gender">Gender</label>
					<br />
					<div class="row">
						<div class=" col-4 form-check form-check-inline">
							<label class="form-check-label"><input
								class="form-check-input" type="radio" name="gender" id="gender"
								value="male"required>Male </label>
						</div>
						<div class="col-4 form-check form-check-inline">
							<label class="form-check-label"><input
								class="form-check-input" type="radio" name="gender" id="female"
								value="female" required> Female </label>
						</div>
					</div>
					<div class="form-group">
						<p id="dotted-bound">
							By Creating an Account with us, you certify that you have read
							the <a href="#">Terms of Use</a> and <a href="#">privacy
								policy</a>
						</p>
					</div>
					<div class="row form-group">
						<div class="col">
							<button type="submit" class="btn btn-lg btn-block btn-success"
								id="button">Create an Account !</button>
							<br>
						</div>
					</div>
					<p>
						Already have an account?<a href="#"><strong> Sign in</strong></a>
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
