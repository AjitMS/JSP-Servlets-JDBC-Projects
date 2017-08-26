<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ToDoApp.*"%>
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

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>

<!-- (Optional) Latest compiled and minified JavaScript translation files -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/i18n/defaults-*.min.js"></script>

<title>Update Task</title>
</head>
<body>
	<div style="margin: 10px;" class="panel panel-success">
		<div class="panel-heading">
			<h2 align="center">Update Task</h2>
			<div style="position: relative; bottom: 50px; float: right;">
				<form action="ToDoLogin.jsp">
					<button title="Click to Logout" type="submit"
						class="btn btn-danger">Logout</button>
				</form>
			</div>
		</div>
		<div style="float: clear"></div>
		<div class="panel-body">
			<div class="cointainer"
				style="margin-left: 20px; margin-top: 20px; margin-right: 400px;">
				<%
					// out.print(request.getParameter("task"));
				%>
					also action is ${action}
				<form action="ToDoUpdateController" method="post">
				
				<%-- <c:set var="action" value="update" scope="request"/>
				<c:set var="old_taskname" value="${task.name}" scope="request"/> --%>
				<input type="hidden" name="command" value="update">
				  <input type="hidden" name="old_taskname" value="${task.name}">
				
					<div class="form-group">
						<label for="text">Task:</label> <input type="text"
							class="form-control" name="name" id="task" value="${task.name}">
					</div>
					<div class="form-group">
						<label for="date">Date:</label> <input title="Select Date"
							type="date" class="form-control" name="date" value="${task.date}">
					</div>

					<div class="form-group">
						<label for="priority">Priority:</label><br> <select
							class="selectpicker" title="Specify Priority" name="priority">
							<option>Normal</option>
							<option>Urgent</option>
							<option>Emergency</option>
						</select>
					</div>
					<br>

					<button title="Add Task to ToDo List" type="submit"
						class="btn btn-success">Confirm</button>
				</form>
				<hr style="border: 1px ridge lightgrey;" />

			</div>
		</div>

	</div>

</body>
</html>