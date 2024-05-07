<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new relief program</title>
</head>
<body>
<%
    String user_id = request.getParameter("user_id");
  %>



	<form action="new_relief" method="post" enctype="multipart/form-data">
		<table>
			<caption>Create New Relief program</caption>
			<tr>
				<td><label>Program name</label></td>
				<td><input name="relief_name" type="text"></td>
			</tr>
			<tr>
				<td><label>Program Description</label></td>
				<td><input name="relief_description" type="text"></td>
			</tr>
			
			

			<tr>
			
				<td> <input name="user_id" value="<%=user_id %>" > </td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>