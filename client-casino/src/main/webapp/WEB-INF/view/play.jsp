<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
function checkValidate()
{
    var first = document.getElementById("first");
    var second = document.getElementById("second");
    var third = document.getElementById("third");
    var fourth = document.getElementById("fourth");
    var fifth = document.getElementById("fifth");
    var sixth = document.getElementById("sixth");
    var even = document.getElementById("even");
    var odd = document.getElementById("odd");
    
   
    var valid = true;
    if(first.value.length<=0 && second.value.length<=0 && third.value.length<=0 && fourth.value.length<=0 && fifth.value.length<=0 && sixth.value.length<=0 && even.value.length<=0 && odd.value.length<=0)
        {
            alert("Don't leave the field empty!");
            valid = false;
        }
        else{
            if(isNaN(firstValue) || isNaN(secondValue) || isNaN(thirdValue) || isNaN(fourthValue) || isNaN(fifthValue) || isNaN(sixthValue) || isNaN(evenValue) || isNaN(oddValue)){
                alert("Enter a number");
        valid = false;}
            else{
            	if(firstValue + secondValue + thirdValue + fourthValue + fifthValue + sixthValue + evenValue + oddValue == 0){
            		alert("Put soome money to Play!")
            		valid = false;
            	}
            	
            	else if( firstValue%500!=0   || secondValue%500!=0  || thirdValue%500!=0  || fourthValue%500!=0  || fifthValue%500!=0   || sixthValue%500!=0  || evenValue%500!=0   || oddValue%500!=0 ){
            		alert("Enter a number multiple of 500");
                    valid = false;
            	}
            }
            
    }
    return valid;
};


</script>


<link rel="stylesheet"
	href="/css/play.css">
<title>Roulette Game</title>
</head>
<body>
<nav class="navbar  navbar-default navbar-collapse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Roulette Game</a>
    </div>
      <ul class="collapse navbar-collapse navbar-right">
        <li><a><spna class="glyphicon glyphicon-user"></spna>Welcome ${name}</a></li>
     
     <%
     	double bal = Double.parseDouble(session.getAttribute("accountBal").toString());
     %>
     
     <li><a><span class="fa fa-inr"></span>
     Balance: <%=bal%>
     </a></li>
     
     <li><a><form method = "post" action = "logout">
     <input id = "logout" type = "submit" value = "logout"
     class = " btn btn-danger">
     </form></a></li>
     
     
      </ul>
    </div>
</nav>

<div id =  abc>
<img alt="" src="/images/american-roulette.jpeg" style="margin-right: 100px; margin-left: 300px; margin-top: 20px" >
</div>
<br><br>
 
<!--   ............................................................ -->

	 <form action="/result" method="post" onsubmit=" return checkValidate()" >    
	   <div class="luckyvalues">
     			<div class="firstrow">
     			<!-- <label>1st 12</label> -->
				
				<div class="col-sm-4">
				 <input type="number"  name="first" placeholder="1st 12" id="first" min=0 step=500>
				</div>
				
				<div class="col-sm-4">
				 <input type="number"  name="second" placeholder="2nd 12" id="second" min=0 step=500>
				</div>
				
				<div class="col-sm-4">
				  <input type="number" placeholder="3rd 12" name="third" id="third" min=0 step=500>
				</div>


			</div>
			
			<br><br>
			
			<div class="secondrow">
			
				<div class="col-sm-4">
				 <input type="number" name="fourth" placeholder="Zero" id="fourth" min=0 step=500>
				</div>
				
				<div class="col-sm-4">
				 <input type="number" placeholder="1-18"  name="fifth" id="fifth" min=0 step=500>
				</div>
				
				<div class="col-sm-4">
				 <input type="number" placeholder="19-36" name="sixth" id="sixth" min=0 step=500>
				</div>


			</div>
			
            <br><br>
            
			<div class="thirdrow">
			
				<div class="col-sm-4">
			    <input type="number" placeholder="even" name="even" id="even" min=0 step=500>
				</div>
				
				<div class="col-sm-4">
				 <input type="number" placeholder="odd" name="odd" id="odd" min=0 step=500>
				</div>
				
				<div class="col-sm-4">
				<button type="button" value="Play" class="btn btn-success"
					data-toggle="modal"  data-target="#myModal">Play</button>
				</div>


			</div>
   

		</div>

	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					
					<p class="modal-title">Try Your Luck</p>
				</div>
				<div class="modal-body">
					<p>want to continue!</p>
				</div>
				<div class="modal-footer">
				    <button type="submit" class="btn btn-primary">Yes</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
				</div>
			</div>
		</div>
	</div>
	  </form>


</body>
</html>