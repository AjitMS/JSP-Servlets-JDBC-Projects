<%@ page language="java" contentType="text/html charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,java.util.List,com.ToDoApp.*"%>
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
<title>To-Do HomePage</title>
</head>
<body>
	<script type="text/javascript">
		window.alert(' Please do not refresh or press F5 on page ')
	</script>
	
	<div class="cointainer"  style = "margin-left:20px; margin-top:20px; margin-right:400px;">
		<form action="ToDoController" method="post">
				<div class="form-group">
				<label for="text">Task:</label> <input type="text"
					class="form-control" id="task" placeholder="Enter Task Name"
					name="name">
			</div>
			<div class="form-group">
				<label for="date">Date:</label> <input type="date"
					class="form-control" id="pwd" name="date">	
			</div>
			
				
			<div class="priority">
			<label for="priority">Priority</label>
				 <select class="form-control" name="priority">
					<option>Normal</option>
					<option>Urgent</option>
						<option>Emergency</option>
				</select>
			</div>	
		<br>	<button type="submit" class="btn btn-success">Submit</button>
		</form>
	<hr>
	
	<%
		@SuppressWarnings(value = "unchecked")
		List<Task> taskList = (List<Task>) session.getAttribute("taskList");
		session.setAttribute("taskList", taskList);
	%>

	<c:forEach items="${taskList}" var="task">
    
            Name: <input type="text" value="${task.name}" />
          Priority: <input type="text" value="${task.priority}" />
          Date: <input type="text" value="${task.date}" />#000000
		<hr style="border: 1px ridge  lightgrey;" />​

	</c:forEach>

	<br><br>
	</div>
</body>
</html>