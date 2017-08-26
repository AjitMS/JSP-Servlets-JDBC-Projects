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
<link rel="stylesheet" type="text/css" href="CSS/signin.css">
</head>
<body>
<div>
	<div class="container-fluid row supercontainer sharpdiv" align="center">
		<div class="border-bottom">
			<h2>Sign In</h2>
		</div>
		<hr>
		<div class="container col-xs-6 subcontainer">
			<table class="table">
				<thead>
					<tr>
						<div class="row">
							<h3 id="faded">Use other accounts</h3>
						</div>
					</tr>
				</thead>
				<tbody>
					<form>
						<tr>
							<div class="row">
								<div class="col">
									<p>you can also sign in using your</p>
								</div>
							</div>
						</tr>
						<tr>
							<p>Facebook Account or Google Account</p>
						</tr>
						<tr>
							<div class="row">
								<div class="col">
									<button id="button" type="submit"
										class="btn btn-default roundbutton facebook">Log in
										with Facebook</button>
								</div>
							</div>
						</tr>
						<br>
						<tr>
							<div class="row">
								<div class="col">
									<button id="button" type="submit"
										class="btn btn-primary roundbutton">Log in with
										Google</button>
								</div>
							</div>
						</tr>
					</form>
				</tbody>
			</table>
		</div>
		<div class="container col-xs-6 subcontainer sideborder">

			<table class="table">
				<thead>
					<tr>
						<div class="row">
							<div class="col">
								<h3 id="faded">Use your accounts</h3>
							</div>
						</div>
					</tr>
				</thead>
				<tbody>
					<form>
						<tr>

							<div class="form-group">

								<input type="email" class="form-control" class="form-control"
									id="email" placeholder="Enter email" name="email">
							</div>

						</tr>

						<tr>

							<div class="form-group">
								<input type="password" class="form-control" id="password"
									placeholder="Enter password" name="password">

							</div>
						</tr>
						<tr>
							<div class="form-group">
								<button id="button" type="submit" class="btn btn-success">Submit</button>
							</div>

						</tr>
						<br>
						<tr>

							<div id="pass">
								<a href="#">Forgot password?</a>
							</div>

						</tr>
						<tr>

							<div id="register">
								<a href="#">Register!</a>


							</div>

						</tr>
					</form>
				</tbody>
			</table>
		</div>
	</div>
	</div>
</body>
</html>