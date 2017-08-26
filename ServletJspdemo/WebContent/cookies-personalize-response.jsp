<html><title>Cookies</title>
<body>
	
	<%
	//read form data
	String lang = request.getParameter("lang");
	//create a acookie
	Cookie cookie = new Cookie("myapp.favoritelanguage", lang);
	//setting life span
	cookie.setMaxAge(60*60*24*365);
	//send cookie to browser
	response.addCookie(cookie);
	%>
	
	Thanks! We set your favorite langauge to: ${param.lang }
	<br /><br />
	<a href="cookies-homepage.jsp">Return back to Homepage ?</a>
	
	
</body></html>