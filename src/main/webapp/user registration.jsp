<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<h1>User Registration Form</h1>
	<form action="user_registration" method="post"
		enctype="multipart/form-data">
		<table>

			<tr>
				<td><label>Name:</label></td>
				<td><input name="user_name" placeholder="Enter name"></td>
			</tr>
			<tr>
				<td><label>NID:</label></td>
				<td><input name="user_nid" placeholder="Enter Nid"></td>
			</tr>

			<tr>
				<td><label>Phone:</label></td>
				<td><input name="user_phone" placeholder="Enter Phone">
				</td>
			</tr>

			<tr>
				<td><label>Email:</label></td>
				<td><input name="user_email" placeholder="Enter Email">
				</td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><input name="user_password" placeholder="Enter Passwrd">
				</td>
			</tr>
			<tr>
				<td><label>Country:</label></td>
				<td><input name="user_country" placeholder="Enter Country">
				</td>
			</tr>
			<tr>
				<td><label>Division:</label></td>
				<td><input name="user_division" placeholder="Enter Division">
				</td>
			</tr>

			<tr>
				<td><label>District:</label></td>
				<td><input name="user_district" placeholder="Enter District">
				</td>
			</tr>

			<tr>
				<td><label>Upazila:</label></td>
				<td><input name="user_upazila" placeholder="Enter Upazila">
				</td>
			</tr>
			<tr>
				<td><label>Union:</label></td>
				<td><input name="user_union" placeholder="Enter Union">
				</td>
			</tr>
			<tr>
			<tr>
				<td><label>Word:</label></td>
				<td><input name="user_word" placeholder="Enter Word"></td>
			</tr>
			<tr>
			<tr>
				<td> <label>Your photo</label> </td>
				<td>
					<input name="user_photo" type="file">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">Submit</button>
				</td>
			</tr>

		</table>
	</form>

</body>
</html>