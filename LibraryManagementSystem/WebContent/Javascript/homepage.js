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
			url : "TestController",

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
			
			$.each(json, function(key, value){
				$('.content').html(value['bookName']+" "+value['bookAuthor']+" "+value['bookCategory']);
				console.log(' array content is '+value['bookName']+" " +value['bookCategory']);
			})
			
			//$('.content').html(value[bookName]+" "+value[bookAuthor]+" "+value[bookCategory]);
		
		})
		// Code to run if the request fails; the raw request and
		// status codes are passed to the function
		.fail(function(xhr, status, errorThrown) {
			alert("Sorry, there was a problem!");
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
		