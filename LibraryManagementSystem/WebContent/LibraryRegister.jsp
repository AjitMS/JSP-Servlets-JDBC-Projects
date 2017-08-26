<%@ page language="java" contentType="text/html charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="CSS/register.css">
	
<title>Register Mandatory</title>
</head>
<body>
	<div  align="center" id="container">

		<table class="table">
			<thead>	
				<tr>
					<div>
						<h2 class="border">Create an account</h2>	
					</div>
				</tr>
			</thead>
			<br>
			<tbody>
				<form>
					<tr>
						<div>
							<div id="float">
								<label for="email">Enter your email address </label>
							</div>
							<input type="email" class="form-control" id="email"
								placeholder="Enter email" name="email">
						</div>
					</tr>
					<br>
					<tr>	
						<div>
							<div id="float">
								<label for="password">Enter your password</label>
							</div>
							<input type="password" class="form-control" id="password"
								placeholder="Enter password" name="password">
						</div>
					</tr>
					<br>
					<tr>
						<div>
							<div id="float">
								<label for="password">Confirm Password</label>
							</div>
							<input type="password" class="form-control" id="password"
								placeholder="Repeat password" name="password">
						</div>
					</tr>
					<br>
					<tr>
						<div>
							<input type="checkbox">By Creating an Account with us,
							you certify that you have read the <a href="#">Terms of Use</a>
							and <a href="#">privacy policy</a>.
						</div>
					</tr>

					<br>
					<tr>
						<div>
							<button type="submit" class="btn btn-success"
								id="button">Create an Account !</button>
						</div>
					</tr><br>
				<tr>
					<p>Already have an account?</p>
					<a href="#"><i>Sign in</i></a>
				</tr>
				</form>
			</tbody>
		</table>
	</div>
</body>
</html>