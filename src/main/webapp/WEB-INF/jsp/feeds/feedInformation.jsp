<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>
	<div class="col-md-8 container">
	  	<h3>XML RSS Feed Details</h3>	  	
	  	<div>
	  		<h4>${feedInformation.feedName}</h4>
	  		<a href="${feedInformation.url}">${feedInformation.url}</a>
	  		<p>Last update: ${feedInformation.lastUpdate}</p>
	 	 	<p>Total articles: ${itemCount}</p> 
	 	 	<form action="/feeds/reload/${feedInformation.id}" method="GET">
	   			<input type="submit" class="btn btn-default"
	 				value="Get newest articles" />
	 		</form>
	  		<br />
	  			  		
	  		<c:forEach var="item" items="${feedItems}">
		  		<div id="itemStyle">
		  			<p>${item.title}</p>
		            <p>${item.description}</p>
		            <a href="${item.link}">Read full article...</a>
		            <hr></hr>
		        </div>
        	</c:forEach>
	  	</div>
	</div>

</body>
</html>