<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
       $(document).ready(function(){
             $("#myModal").modal('show');
       });
</script>
</head>
<body>
<div id="myModal" class="modal fade">
    <div  class="modal-dialog">
        <div style="width: 50%" class="modal-content">
            <div class="modal-body">
                    <div class="form-group">
                       <p>You have insufficient amount of balance in your account.</p>
                    </div>
                    
                    <div class = "row">
    				<div class="col-md-4">
                    <form action="/logout" method="post">
                    <button type="submit" class="btn btn-primary">Close</button>
                    </form>
                    </div>
                    <div class="col-md-4">
                    <form action="/valid" method="post"  >
                     <input type="hidden" name="userID" value=${id} >
                    <button type="submit" class="btn btn-primary">Reset Game</button>
                    </form>
                    </div>
                    </div>
               
            </div>
        </div>
    </div>
</div>
</body>
</html>
