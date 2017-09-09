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
		class="navbar-text silvertext"> Hello, ${user.fullname} ! </span>

	<ul class="nav">
		<li class="nav-item"><a class="nav-link active" href="#">Active</a></li>
		<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
		<li class="nav-item"><a class="nav-link " href="#">Link</a></li>
	</ul>
	<input type="button" class="btn btn-outline-danger" value=Logout>
	</nav>


	<!-- Modal -->

	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">New message</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="modal-body">
					
					<div class="container-fluid" >
					<table class="table" id="booktable">
					
					</table>
					</div>

				</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Send message</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Cards -->
	<div
		class="col-md-10
 justify-content-right container container-margin ">
		<div class="row">
			<div class="col-md-4 col-sm-12">
				<div class="card">
					<h4 class="card-header">Arts</h4>
					<div class="card-body">
						<h4 class="card-title">Arts Section</h4>
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<a href="#" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModal" data-whatever="Arts">List Books</a>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-12">
				<div class="card">
					<h4 class="card-header">Commerce</h4>
					<div class="card-body">
						<h4 class="card-title">Commerce Section</h4>
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<a href="#" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModal" data-whatever="Commerce">List
							Books</a>
					</div>
				</div>
			</div>

			<div class="col-md-4 col-sm-12">
				<div class="card">
					<h4 class="card-header">Science</h4>
					<div class="card-body">
						<h4 class="card-title">Science Section</h4>
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<a href="#" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModal" data-whatever="Science">List
							Books</a>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col" align="right">
				<br /> <input type="button" class="btn btn-outline-success btn-lg"
					value="+" data-toggle="modal" data-target="#exampleModal"
					data-whatever="Add new Book">
			</div>
		</div>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	
	<script>
	
	$(document).ready(function(){
		
		$('#exampleModal').on('show.bs.modal', function (event) {
			  var button = $(event.relatedTarget) // Button that triggered the modal
			  var bookCategory = button.data('whatever') // Extract info from data-* attributes
			  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			  var modal = $(this)
			  modal.find('.modal-title').text(bookCategory+'.')
			
			console.log('Hell');	
	    

	   
			$.ajax({

				// The URL for the request
				url : "HomepageController",

				// The data to send (will be converted to a query string)
				data : {
					id : 123,
					category : bookCategory
				},

				// Whether this is a POST or GET request
				type : "GET",

				// The type of data we expect back
				dataType : "json",
			})
			// Code to run if the request succeeds (is done);
			// The response is passed to the function
			.done(function(json) {
					
				var html = " <thead> <tr> <th> Book Name </th> <th> Action </th> </tr> </thead> "
				$.each(json, function(key, value){
					$('#booktable').html("");
					html+="<tbody><tr><td>"+value['bookName']+"</td> </tr></tbody>";
					
					console.log(' array content is '+value['bookName']+" " +value['bookCategory']);
				})
				
				$('#booktable').html(html);
				
				//$('.content').html(value[bookName]+" "+value[bookAuthor]+" "+value[bookCategory]);
			
			})
			// Code to run if the request fails; the raw request and
			// status codes are passed to the function
			.fail(function(xhr, status, errorThrown) {
				alert("Sorry, No books found!");
				console.log("Error: " + errorThrown);
				console.log("Status: " + status);
				console.dir(xhr);
			})
			// Code to run regardless of success or failure;
			/* .always(function(xhr, status) {
				alert("The request is complete!");
			}); */
			
			
	});

	});
			
	
	</script>
	
<!--  	<script src="Javascript/homepage.js"></script> -->

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
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