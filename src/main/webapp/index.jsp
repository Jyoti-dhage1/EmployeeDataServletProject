<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Login page</title>
	<link rel="stylesheet" href="css/style.css">
<style>
	#successMessage{
		color:green;
		font-weight: bold;	
		font-size: 20px;		
	}
	#errorMessage{
		color:red;
		font-weight: bold;	
		font-size: 20px;		
	}
	</style>	

</head>
<body>
<div class= "mycontainer2">
	<p id="successMessage">${requestScope.successMessage}</p>
	<p id="errorMessage">${requestScope.errorMessage}</p>

	<h2>Login here</h2>

	<form action="emplogin" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" placeholder="Enter your name" name="name1" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" placeholder="password" name="pass1"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">Submit</button>
					<button type="reset">Reset</button>
				</td>
			</tr>			
		</table>
	</form>
<br>
<span id="bottom">Don't have an account? <a href="register.jsp">  Register</a></span>


</div>

</body>
</html>