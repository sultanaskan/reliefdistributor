<!DOCTYPE html>
<%@page import="distributor.daoImpl.Database"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="distributor.daoImpl.ReliefMemberDaoImpl"%>
<%@page import="distributor.entity.ReliefMember"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@page import="distributor.entity.User"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<link rel="stylesheet" href="style/style.css">

</head>

<body>

	<%
	Connection conn = new Database().Dbconn();
	User user = (User) session.getAttribute("loged_user");
	ReliefMemberDaoImpl reliefmember = new ReliefMemberDaoImpl(conn);
	ArrayList<String> rids = reliefmember.findAllReliefId(user);
	System.out.println(rids);
	String user_id  = null ;
	try{
		user_id =  user.getUser_id();
	}catch(Exception e) {
		
	}
	request.setAttribute("loged_user", user);
	
	

	// Assuming "user" is the session attribute name
	%>





	<header>
		<h1>Welcome Relief Distribution Management System</h1>
	</header>

	<nav>
		<a href="#section1">Root Administrative</a> <a href="#section2">Representative</a>
		<a href="#section3">Only Members</a> <a href="#section3">Others </a>
		<!-- Profile button in the sticky navbar -->
		<a href="/profile">Profile</a>
	</nav>


	<section id="section1">
		<h2>Root Administrative Relief Program</h2>
		<p>I am the root admin of that relief Program.</p>
		<!-- List with links styled as buttons -->
		<ul class="button-list">
			<li><a href="../new_relief.jsp?user_id=<%=user_id %>" class="button-link">New Relief Program +</a></li>
			<li><a href="dashboard.jsp" class="button-link"> Government Relief x</a></li>
			
		</ul>
	</section>
	<hr>

	<section id="section2">
		<h2>My Representative</h2>
		<p>I am the Representative of that relief Program</p>
	</section>
	<hr>


	<section id="section3">
		<h2>Only Members</h2>
		<p>I am the Only Member of that relief Program</p>
	</section>
	<hr>


	<section id="section4">
		<h2>Others Relief Program</h2>
		<p>I am not involved that relief Program.</p>
	</section>


	<footer>
		© 2024 Md Askan Ali (Sultan). All rights reserved. | <a
			href="/terms-of-service">Terms of Service</a> | <a href="/contact">Contact
			Us</a>
	</footer>
</body>
</html>
