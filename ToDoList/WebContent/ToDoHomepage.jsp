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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">


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

<title>To-Do HomePage</title>
</head>

<body>

	<c:if test="${error} == 'error'">
		<script type="text/javascript">
			window.alert('Task already Exists');
		</script>
	</c:if>

	<div style="margin: 10px;" class="panel panel-success">
		<div class="panel-heading">
			<h2 align="center">Working ToDo App</h2>
		</div>
		<div style="position: relative; bottom: 50px; float: right;">
			<form action="ToDoLogin.jsp">
				<button title="Click to Logout" type="submit" class="btn btn-danger">Logout</button>
			</form>
		</div>

		<div class="panel-body">
			<div class="cointainer"
				style="margin-left: 20px; margin-top: 20px; margin-right: 400px;">

				<form action="ToDoController" method="post">

					<input type="hidden" name="action" value="add" />
					<div class="form-group">
						<label for="text">Task:</label> <input title="Enter Task Name"
							type="text" class="form-control" id="task"
							placeholder="Enter Task Name" name="name">
					</div>
					<div class="form-group">
						<label for="date">Date:</label> <input title="Select Date"
							type="date" class="form-control" id="date" name="date">
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
						class="btn btn-success">Submit</button>
				</form>
				<hr style="border: 1px ridge lightgrey;" />

			</div>
			<div>
				<h3 align="center">ToDo List</h3>
			</div>

			<div>
				<table class="table table-striped">
					<thead>

						<tr>
							<th>Task Name</th>
							<th>Date</th>
							<th>Priority</th>
							<th>Action</th>
						</tr>
					</thead>
					<c:forEach items="${taskList}" var="task">
						<%
							//request.setAttribute("task",${task.name});
						%>
						<tbody>
							<tr>
								<td>${task.name}</td>
								<td>${task.date}</td>
								<td>${task.priority}</td>
								<td>
									<form action="ToDoController" method="get">

										<c:set var="taskname" value="${task.name}" scope="request" />
										<c:url var="del" value="ToDoController?action=delete">
											<c:param name="taskname" value="${task.name}" />

										</c:url>
										<p>
											<a href="${del}">Delete</a>
											<!-- <script>window.Alert('Task '+${task.name}+' deleted !');</script> -->
											<c:url var="upd" value="ToDoController?action=update">
												<c:param name="taskname" value="${task.name}" />
											</c:url>
										<p>
											<a href="${upd}">Update</a>

											<%-- <a href="<c:url value = "ToDoUpdateController?action=delete"/>"
											title="Delete Task">Delete</a> | <a
											href="<c:url value = "ToDoUpdateController?action=update"/>"
											title="Update Task">Update</a> --%>
									</form>
								</td>
							</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div align="center" class="panel-footer">
				<h2>Thank You !</h2>
			</div>
		</div>
	</div>
	<br>
	<br>

</body>
</html>