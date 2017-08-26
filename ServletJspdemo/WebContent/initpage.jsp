<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Init Implementation</title>
</head>
<%!public void jspInit() {
		String defaultUser = getServletConfig().getInitParameter("defaultUser");
		ServletContext context = getServletContext();
		context.setAttribute("defaultUserName", defaultUser);

	}%>

<body>



	The Default User is:
	<%=getServletConfig().getInitParameter("defaultUser")%>
	<br />The Value in the Servlet Context is
	<%=getServletContext().getAttribute("defaultUserName")%>

</body>
</html>