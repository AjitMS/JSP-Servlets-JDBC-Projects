<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.LoginApp.dto.User.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Successful !</title>
</head>
<body style="background-color: lightgrey;">

	<h1>Login Successful !</h1>



	<jsp:useBean id="user" class="com.LoginApp.dto.User.User"
		scope="request">
		<jsp:setProperty property="userName" name="user"
			value="Cersei Lannister" />
	</jsp:useBean>



	Hello:
	<jsp:getProperty property="userName" name="user" />


</body>
</html>