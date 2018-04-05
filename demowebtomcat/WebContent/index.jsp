   
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    

<!DOCTYPE PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- <meta charset="utf-8"> -->
		<title>Bootstrap time...</title>
		<!-- css de bootstrap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<!-- css perso -->
		<link rel="stylesheet" href="css/style.css">
		<!-- js perso si besoin -->
		<script src="javascript/script.js" type="text/javascript"></script>
		
		<!-- jquery de bootstrap -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		
	</head>
	<body>
		
		<div class="container opacityContainer">		
			
			<!-- menu -->
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active testMenu">
							<a class="nav-link" href="#">Welcome<span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="create.html">Create</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="ServletClient">Client</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="allGood.html">All good</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="error.html">Error</a>
						</li>
					</ul>
				</div>
			</nav>
			
			<!-- contenu de la partie central -->
			<div>
				<!-- titre -->
				<h1 class="positionTitre">G'day, mate</h1>
				
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Nom</th>
				      <th scope="col">Prenom</th>
				    </tr>
				  </thead>
				  <tbody>

						<c:forEach items="${listClient}" var="client">

							    <tr>
							      <th scope="row"><c:out value="${client.id}"></c:out></th>
							      <td><a href="ServletClient?idClient=${client.id}"><c:out value = "${client.nom}"/></a></td>
							      <td><c:out value = "${client.prenom}"/></td>
							    </tr>
							    

						</c:forEach>
					
				  </tbody>
				</table>
				
			</div>
			
			
		</div>
		
	</body>
</html>