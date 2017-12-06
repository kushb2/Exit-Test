<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
    <div class="modal-dialog ">
        <div style="width: 60%" class="modal-content ">
            <!-- <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Try Your Luck</h4>
            </div> -->
            <div class="modal-body">
                          
                <div>
                    <div class="form-group">
                        <p>Your Lucky number is ${rouletteNumber} </p>
                    </div>
                    <div class="form-group">
                   <c:if test = "${updatedBal > 0}">
                          winning Amount ${win} .
                    </c:if>
                    <c:if test = "${updatedBal <= 0}">
                          Lost.
                    </c:if>
                    </div>
                    
                <!--      <div class="row">
    <div class="col-md-12">
      <router-outlet></router-outlet>
    </div>-->
    				<div class = "row">
    				<div class="col-md-4">
                    <form action="/logout" method="post">
                    <button type="submit" class="btn btn-primary">Exit</button>
                    </form>
                    	</div>
                    	<div class="col-md-4">
                     <form action="/valid" method="post"  >
                     <input type="hidden" name="userID" value=${id} >
                    <button type="submit" class="btn btn-primary">Play Again</button>
                    </form>
                    </div>
                    </div>
                   
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
