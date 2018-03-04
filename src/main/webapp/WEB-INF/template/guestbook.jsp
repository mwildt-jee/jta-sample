<%@ page import="de.hsw.jee.sample.model.*" %>
<%@ page import="java.util.*" %>

<html>
	<head>
	
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
		<title>JTA Sample Guestbook</title>
		
	</head>
	<body>
		
		<div class="container container-fluid">
		
			<h1>Willkommen im JTA Sample Guestbook</h1>
			
			<h2>Einttrag Schreiben</h2>
			
			<form method="POST">
			
					<div class="form-group">
						<label for="message"></label> 
						<textarea name="message" class="form-control"></textarea>
					</div>
	
	
					<div class="form-group">
						<label for="author">Benutzer</label> 
						<input name="author" class="form-control" />
					</div>
	
					<button class="btn btn-primary" type="submit">Veröffentlichen</button>
				
			</form>
				
			<h2>Eintraege</h2>
				
			<% for(GuestbookEntry entry : (List<GuestbookEntry>) request.getAttribute("entries")) { %>
				<div class="well">
					<h3><%= entry.getAuthor() %></h3>
					<p><%= entry.getMessage() %></p>
				</div>
				
			<% } %>
		</div>
		
	</body>

</html>

