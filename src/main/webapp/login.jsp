<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<h1>User Login</h1>
	<form action="user_login" method="post">
		<table>
			<tr>
				<td><label>Phone: </label></td>
				<td><input name="user_phone" type="text"
					placeholder="your phone number"></td>
			</tr>
			<tr>
				<td><label>Password: </label></td>
				<td><input name="user_password" type="password"
					placeholder="your Password"></td>
			</tr>
			<tr> <td></td> <td> <button type="submit">Login</button> </td> </tr>
		</table>
	</form>

</body>
</html>