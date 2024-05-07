
<%@page import="java.sql.Connection"%>
<%@page import="distributor.daoImpl.Database"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
Connection conn = new Database().Dbconn();

 %>
 <%=conn %>

</body>
</html>