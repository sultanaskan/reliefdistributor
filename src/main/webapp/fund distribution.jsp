<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="fund_distribution" method="post">
		<table>
		<caption>Fund Distribution form</caption>
			<tr>
				<td><label>Fund Distribution id</label></td>
				<td><input name="fund_distribution_id"></td>
			</tr>
			<tr>
				<td><label>Relief id</label></td>
				<td><input name="relief_id"></td>
			</tr>
			<tr>
				<td><label>Distributor id</label></td>
				<td><input name="fund_distributor_id"></td>
			</tr>
			<tr>
				<td><label>Fund collector id</label></td>
				<td><input name="fund_collector_id"></td>
			</tr>
			
			<tr>
				<td><label>Fund Item id</label></td>
				<td><input name="fund_item_id"></td>
			</tr>
			
			<tr>
				<td><label>Fund Item Quantity</label></td>
				<td><input name="item_quantity"  type="number"></td>
			</tr>
			<tr>
				<td><label>Date</label></td>
				<td><input name="date" type="date"></td>
			</tr>
			<tr>
				<td><label>Status</label></td>
				<td><input name="status" ></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>