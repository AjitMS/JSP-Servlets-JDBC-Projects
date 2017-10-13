<%@ page language="java" contentType="text/html charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,java.util.List,com.todo.*"%>
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
</head>
<body style="background-color: #E8E8E8;">

		<c:if test="${error eq 'error'}">
		<script type="text/javascript">
			window.alert(' Email or Password is incorrect. Try Again ')
		</script>
	</c:if>
	
	<div class="container" align = "center" style="width: 500px; background-color: white; margin-top:150px;">
	
	<table class="table">
	<thead>	
	<tr><div><h2> Please Log in</h2></div></tr>
	</thead>
	<tbody>
	<form action="ToDoLoginController" method="post">
	<tr> <div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					name="email">
			</div>  </tr>
	
	<tr>  <div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="password">
			</div>  </tr>
	<tr>  </div>ToDoControllerToDoController"> 
			<div class="checkbox">
				<label><input type="checkbox" name="remember">
					Remember me</label>
			</div>  </tr>
	
	<tr>  <div><button type="submit" class="btn btn-success" style="width: 460px;">Submit</button></div></tr>
			<tr> Not yet Registered? <a href="ToDoRegister.html"><i> Register Now !</i></a> </tr>
	</form>
	</tbody>
	</table>
	</div>

</body>
</html>