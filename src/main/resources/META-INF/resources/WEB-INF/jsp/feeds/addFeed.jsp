<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>
	<div class="col-md-4 container">
	  	<h3>Add XML RSS Feed</h3>
	  	<p>Please provide new XML RSS Feed information</p>
		<form:form class="form-horizontal" action="/feeds/add" method="POST" modelAttribute="feed">
		  <div class="form-group">
		    <form:label for="inputURL" class="col-md-4 control-label" path="url">XML RSS Feed URL:</form:label>
		    <div class="col-md-8">
		    	<form:input type="text" class="form-control" id="inputURL" placeholder="URL" path="url"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <form:label for="inputFeedName" class="col-md-4 control-label" path="feedName">XML RSS Feed Name:</form:label>
		    <div class="col-md-8">
		    	<form:input type="text" class="form-control" id="inputFeedName" placeholder="Name" path="feedName"/>
		    </div>
		  </div>
		  <input type="submit" class="btn btn-default" value="Add Feed" />
		</form:form>
	</div>
</body>
</html>