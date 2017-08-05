<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Generic Random Title</title>
</head>
<body>

	<div align="center">
		<b><i>The Time is: <%=new Date()%></i></b>
	</div>

	<%@ include file="/newtest.jsp"%>
</body>
</html>