<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="add_fund_below" method="post">
		<table>
			<tr>
				<td><label>Item id</label></td>
				<td><input name="fund_below_id"></td>
			</tr>
			<tr>
				<td><label>Relief id</label></td>
				<td><input name="relief_id"></td>
			</tr>
			<tr>
				<td><label>Holder name</label></td>
				<td><input name="holder_id"></td>
			</tr>
			<tr>
				<td><label>Item  Id</label></td>
				<td><input name="item_id"></td>
			</tr>
			<tr>
				<td><label>Item Quantity</label></td>
				<td><input name="item_quantity" type="number"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>