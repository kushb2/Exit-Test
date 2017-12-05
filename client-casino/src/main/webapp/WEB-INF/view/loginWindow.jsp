<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="/css/loginWindow.css"> 
 

<title>Login</title>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Home</a>
    </div>

    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li ><a href = "/loginWindow">Login</a></li>
        

      </ul>
    </div>
  </div>
</nav>


<div class="row">
  <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
  
    <form method = "post" action = "/valid" class = "form" >
      <div class="form-group">
        <label for="userID">Secret ID</label>
         
        <input type="number" id="userID" name="userID" class="form-control" placeholder = "Enter Secret ID" required>
      <font color = "red">${invalid}</font> 
      </div>
     <input id = "login" type = "submit" class = "btn btn-primary" value = "Start Game" >
    </form>
  </div>
</div>
</body>
</html>
