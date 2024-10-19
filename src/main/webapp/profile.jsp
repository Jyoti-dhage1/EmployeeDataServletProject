<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home Page</title>
	<link rel="stylesheet" href="css/style.css">
	
</head>
<body>
	<header>
		<div class="header-content">
			<h1>Welcome ${sessionScope.first_name}</h1>
			<nav>
	             <ul>
	                 <li id='first'><a href='delete.jsp'>Delete Your Profile</a></li>
	                 <li><a href='logout'>Log out</a></li>
	             </ul>
	        </nav>		
		</div>
	</header>

	<div class="mycontainer">
		<h2 >My Profile</h2>
		<table>
			<tr>
				<td>First Name:</td>
				<td>${sessionScope.first_name}</td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td>${sessionScope.last_name}</td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>${sessionScope.gender}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${sessionScope.email}</td></tr>
			<tr>
				<td>Mobile Number:</td>
				<td>${sessionScope.mobile_no}</td>
			</tr>
			<tr>
				<td>Dob:</td>
				<td>${sessionScope.dob}</td>
			</tr>
			<tr>
				<td>Passing year:</td>
				<td>${sessionScope.passing_yr}</td>
			</tr>
			<tr>
				<td>Specialisation:</td>
				<td>${sessionScope.specia}</td>
			</tr>
			<tr>
				<td>Semester:</td>
				<td>${sessionScope.semester}</td>
			</tr>
			<tr>
				<td>10th percentage:</td>
				<td>${sessionScope.ten_percentage}</td>
			</tr>
			<tr>
				<td>12th percentage:</td>
				<td>${sessionScope.twelth_percentage}</td>
			</tr>
			<tr>
				<td>Graduation Percentage:</td>
				<td>${sessionScope.graduation_per}</td>
			</tr>
			<tr>
				<td>fresher/experience:</td>
				<td>${sessionScope.fresher_experience}</td>
			</tr>
		</table>
	</div>
</body>
</html>