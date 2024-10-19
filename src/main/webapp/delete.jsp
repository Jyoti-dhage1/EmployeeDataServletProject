<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Delete Page</title>
	<link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class="mycontainer3">
	<h2>Please Provide below information</h2>
	<form action="delete" method="post">
		<table>
			<tr>
				<td>Enter your email</td>
			</tr>
			<tr>
				<td><input type="text" placeholder="Enter here" name="email" /></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td>Enter your password</td>
			</tr>
			
			<tr>
				<td><input type="password" placeholder="Enter here" name="pass1" /></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td><button type="submit">Submit</button>&nbsp;&nbsp;&nbsp;<a href=# onclick="history.back()">Go back</a></td>
			</tr>
		
		</table>
	</form>

	</div>
</body>
</html>