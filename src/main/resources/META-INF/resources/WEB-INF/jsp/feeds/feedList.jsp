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
	<div class="col-md-4 container">
	  	<h3>XML RSS Feed</h3>
	  	<p><a href="/feeds/add">Add new Feed</a></p>
	  	<p>Please find the list of all available feeds</p>
	  	
	  	<div>
	  	 <c:forEach var="feedElement" items="${feedList}">
            <a href="/feeds/${feedElement.id}">${feedElement.url}</a>
            <br />
        </c:forEach>
	  	</div>
	</div>

</body>
</html>