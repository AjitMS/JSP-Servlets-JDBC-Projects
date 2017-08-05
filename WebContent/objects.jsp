<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kindness and Politeness</title>
</head>
<body>

	<%
		String userName = request.getParameter("name");

		if (userName != null) {
			pageContext.setAttribute("pageContextUserName", userName);//DEFAULT: PAGE_CONTEXT
			pageContext.setAttribute("applicationUserName", userName, PageContext.APPLICATION_SCOPE);//For Application
			pageContext.setAttribute("sessionUserName", userName, PageContext.SESSION_SCOPE);//For Session
			//session.setAttribute("sessionUserName", userName);
			//application.setAttribute("applicationUserName", userName);
		}
	%>

	<br /> Request UserName is
	<%=userName%>
	<br /> Session UserName is
	<%=session.getAttribute("sessionUserName")%>
	<br /> Application UserName is
	<%=application.getAttribute("applicationUserName")%>
	<br /> Page Context UserName is
	<%=pageContext.getAttribute("pageContextUserName")%>


</body>
</html>