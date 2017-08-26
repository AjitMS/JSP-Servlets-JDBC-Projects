<html>
<title>***Homepage***</title>
<body>
	<h3>Training Portal</h3>
	<!-- Read the favorite programming language cookie -->
	<%
		//the default...if no cookie
		
		String lang = "Java";
	
		// get the cookies from browser window
		
		Cookie cookies[] = request.getCookies();
		
		//find out favorite language
		
		if (cookies != null)
			for (Cookie tempcookie : cookies) {
				if ("myapp.favoritelanguage".equals(tempcookie.getName())) {
					lang = tempcookie.getValue();
					break;
				}
			}
	%>

<!-- now show personalized page ... use the lang variable -->
<!-- Show books for this language -->
<h4>New Books for <%= lang %></h4>
<ul>
<li>blah blah blah</li>
<li>blah blah blah</li>
<li>blah blah blah</li>
</ul>

<h4>News Reports for <%= lang %></h4>
<ul>
<li>blah blah blah</li>
<li>blah blah blah</li>
<li>blah blah blah</li>
</ul>

<h4>Hot Jobs for <%= lang %></h4>
<ul>
<li>blah blah blah</li>
<li>blah blah blah</li>
<li>blah blah blah</li>
</ul>
<hr />
<a href="cookies-personalize-form.html">Personalize this Page ?</a>
</body>
</html>