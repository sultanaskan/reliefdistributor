<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Item</title>
</head>
<body>
	<form action="add_item" method="post">
		<table>
		 <caption>Add new Item</caption>
			<tr>
				<td><label>Relief id:</label></td>
				<td><input name="relief_id"></td>
			</tr>
			<tr>
				<td><label>Item name:</label></td>
				<td><input name="item_name"></td>
			</tr>
			<tr>
				<td><label>Item unit:</label></td>
				<td><input name="item_unit"></td>
			</tr>
			<tr>
				<td><label>Item price:</label></td>
				<td><input name="item_price"></td>
			</tr>
			<tr>
			<td></td><td><input type="submit"> </td>
			</tr>
		</table>
	</form>

</body>
</html>