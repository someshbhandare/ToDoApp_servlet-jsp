<%@page language='java' contentType='text/html' %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ToDo App</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
	<link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">
	<div class="card mt-2">
	    <div class="card-header">
	        <h1 class="text-center">ToDo App</h1>
	    </div>
	    <div class="card-body">
	        <form action="update_task" method="post">
	            <div class="input-group mb-3">
	                <div class="input-group-text" data-toggle="tooltip" data-placement="bottom" title="Marked as completed">
	                    <c:choose>
	                    	<c:when test="${task.isCompleted()}">
	                    		<input type="checkbox" class="form-check-input" name="completed" id="box" onclick="chgFlag(this.checked)" checked>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<input type="checkbox" class="form-check-input" name="completed" id="box" onclick="chgFlag(this.checked)">
	                    	</c:otherwise>
	                    </c:choose>
	                </div>
	                <input type="text" class="form-control" name="new_task" value="${task.getTask()}">
	                <input type="hidden" name="id" value="${task.getId()}">
	                <button type="submit" class="btn btn-lg btn-info">Update</button>
	            </div>
	        </form>
	    </div>
	</div>
</div>
	
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script>
  function chgFlag(chk){
    var box = document.getElementById("box");
    box.value = chk;
  }
 </script>
</body>
</html>