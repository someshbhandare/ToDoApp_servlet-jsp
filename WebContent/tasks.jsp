<%@page language='java' contentType='text/html' import="java.util.ArrayList" %>
<%@page import="com.somesh.web.model.Task" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ToDo App</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
	<link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container h-100">
	<div class="card mt-2">
	    <div class="card-header">
	        <h1 class="text-center">ToDo App</h1>
	    </div>
	    <div class="card-body">
	        <form action="add_task" method="post">
	            <div class="input-group mb-3">
	                <input type='text' class="form-control" name="task" placeholder="Enter task..." required>
	                <button type="submit" class="btn btn-primary btn-lg">ADD</button>
	            </div>
	        </form>
	        <h4 class="bg-warning text-light py-2 rounded text-center">My Tasks:</h4>
	        <c:forEach var="task" items="${tasks}">
		        <ul class="list-group">
		            <li class="list-group-item list-group-item-action">
		            	<c:choose>
			            	<c:when test="${task.isCompleted()}">
			            		<strike><c:out value="${task.getTask()}"></c:out></strike>
			            	</c:when>
			            	<c:otherwise>
			            		<c:out value="${task.getTask()}"></c:out>
			            	</c:otherwise>
		            	</c:choose>
		                <div class="float-end">
		                    <a href="show_update?id=${task.getId()}" class="btn btn-sm btn-info">Update</a>
		                    <a href="delete_task?id=${task.getId()}" class="btn btn-sm btn-danger">Delete</a>
		                </div>
		            </li>
		        </ul>
			</c:forEach>
	    </div>
	</div>
</div>
	
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>

</body>
</html>