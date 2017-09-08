<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="CSS/homepage.css" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

<title>Library Homepage</title>
</head>
<body>

	<nav class="navbar navbar-dark bg-dark"> <span
		class="navbar-text silvertext"> Hello, User ! </span>

	<ul class="nav">
		<li class="nav-item"><a class="nav-link active"
			href="#">Active</a></li>
		<li class="nav-item"><a class="nav-link" href="#">Link</a>
		</li>
		<li class="nav-item"><a class="nav-link " href="#">Link</a>
		</li>
	</ul>
	<input type = "button" class="btn btn-outline-danger"value = Logout>
	</nav>

Email is: ${email}
<div class="col-md-10
 justify-content-right container container-margin ">
<div class="row">
  <div class="col-md-4 col-sm-12">
    <div class="card">
      <h4 class="card-header">Arts</h4>
      <div class="card-body">
        <h4 class="card-title">Arts Section</h4>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">List Books</a>
      </div>
    </div>
  </div>
  <div class="col-md-4 col-sm-12">
    <div class="card">
      <h4 class="card-header">Commerce</h4>
      <div class="card-body">
        <h4 class="card-title">Commerce Section</h4>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">List Books</a>
      </div>
    </div>
  </div>
  
  <div class="col-md-4 col-sm-12">
    <div class="card">
      <h4 class="card-header">Science</h4>
      <div class="card-body">
        <h4 class="card-title">Science Section</h4>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">List Books</a>
      </div>
    </div>
  </div>
</div>
<div class="row">
<div class="col" align="right">
<br />
<input type="button" class="btn btn-outline-success btn-lg" value="+">
</div>
</div>
</div>
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
</body>
</html>