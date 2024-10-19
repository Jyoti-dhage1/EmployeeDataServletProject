<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register Page</title>
	<link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class = "mycontainer4">
	<h2>Registration Form</h2>

	<form id="myform" action="empregister" method="post" >
	<table>
		<tr>
			<td>
				First Name:
			</td>
			<td>
				<input type="text" name="fname1" placeholder="Enter here" required/>
			</td>
		</tr>
		<tr>
			<td>
				Last Name:
			</td>
			<td> 
				<input type="text" name="lname1" placeholder="Enter here" required/>
			</td>
		</tr>
		<tr>
			<td>
				Gender
			</td>
			<td>
				<input type="radio" name="gender" value="Male"/>Male &nbsp;
				<input type="radio" name="gender" value="Female"/>Female &nbsp;
				<input type="radio" name="gender" value="Others"/>Others &nbsp;
			</td>
		</tr>
		<tr>
			<td>
				Email:
			</td>
			<td>
				<input type="text" name="email" placeholder="Enter here" required/>
			</td>
		</tr>
		<tr>
			<td>	
				password:
			</td>
			<td>
				<input type="password" name="pass1" placeholder="Enter here" required/>
			</td>
		</tr>
		<tr>
			<td>
				Mobile_No:
			</td>
			<td>
				<input type="text" name="mobileno" placeholder="Enter here" required/>
			</td>
		</tr>
		<tr>
			<td>
				Date Of Birth:
			</td>
			<td>
				<input type="Date" name="dob" placeholder="Enter here" required/>
			</td>
		</tr>
		<tr>
			<td>
				Degree passing year:
			</td>
			<td>
				<input type="text" name="passingyr" placeholder="Enter here" required/>
			</td>
		</tr>
		<tr>
			<td>
				Specialization:
			</td>
			<td>
				<select name="specia">
					<option value="Btech-ENTC">Btech-ENTC</option>
					<option value="BA">BA</option>
					<option value="Btech-Computer">Btech-Computer</option>
					<option value="Btech-Mechanical">Btech-Mechanical</option>
					<option value="Btech-Civil">Btech-Civil</option>
					<option value="BCA">BCA</option>
					<option value="BSC-Computer">BSC-Computer</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				semester:
			</td>
			<td>
				<input type="text" name="sem" placeholder="Enter here" required/>
			</td>
		</tr>
		<tr>
			<td>
				10th %:
			</td>
			<td>
				<input type="text" name="ten" placeholder="Enter here" required/>
			</td>
		</tr>
		<tr>
	   		<td>
	   			12th %:
	   		</td>
	   		<td> 
	   			<input type="text" name="twelth" placeholder="Enter here" required/>
	   		</td>
		</tr>
		<tr>
	   		<td>
	   			Graduation %:
	   		</td>
	   		<td>
	   			<input type="text" name="grad" placeholder="Enter here" required/>
	   		</td>
		</tr>
		<tr>
	   		<td>
	   			Fresher/Experienced :
	   		</td>
	   		<td> 
	   			<input type="text" name="freshexp" placeholder="Enter here" required/>
	   		</td>
		</tr>	
		<tr>
			<td style="text-align: right">
				<input type="checkbox" value="checked" name="condition" required/>
			</td>
			<td>
				<p>By creating an account you agree to our <a href = #>Term & Privacy</a>
			</td>
		</tr>
		<tr>
			<td>
			</td>
			<td>	
				<button type = "submit">Register</button>
				<button type = "reset">Reset</button>
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>