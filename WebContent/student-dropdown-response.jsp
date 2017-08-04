<html>
<title>Enter Title Here !</title>
<body>
	
		The Student is Confirmed: ${param.firstname} ${param.lastname }
		from ${param.country } 
		
		<br /><br />
		Favorite Programming Languages are: 
		<!-- Display list of Programming languages -->
		
		<ul style="background-color:lightgrey">
			<%
			
			String[] langs = request.getParameterValues("lang");
			for(String temp : langs){
				out.println("<li>"+ temp + "</li>");			
			}
				
			
			%>
		
		
		</ul>		
	
</body></html>