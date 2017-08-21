<%@page import="javax.websocket.Session"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ToDo Web App</title>
</head>
<body>

	<form  action="todolist.jsp" method="post">
		<br /> Enter Task: <input type="text" name="task" /> <input
			type="submit" name="submit" />
	</form>
	<c:set var="itemList" value="${sessionScope['list']}"/>
	<%
		
		List<String> itemList = (List<String>) session.getAttribute("list")    ;
		String item = request.getParameter("task");
		if (itemList == null) {
			itemList = new ArrayList<>();

		}
		if (item != null && item.trim() != "")
			itemList.add(item);
		session.setAttribute("list", itemList);
	%>
	<hr>
	<%
		out.print("items in list are: ");
		for (String temp : itemList)
			out.print("<li>" + temp + "</li>" + "<br>");
	%>
</body>
</html>