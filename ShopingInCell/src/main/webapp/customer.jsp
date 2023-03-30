<%@page import="dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<link rel="stylesheet" href="background.css">
<style>
	body{
		border:2px solid black;
		padding:145px;
		margin:10px;
	}
	button{
		background-color:red;
	}
	body .a {
		border:5px solid black;
		width:400px;
		height:auto;
		margin:auto;
		margin-top:20px;
	}
	h4 :hover{
		color:red;
	}
	button{
		height:25px;
		width:60px;
	}
	button:hover{
		background-color:white;
		color:black;
	}

</style>
</head>
<body>
<div class="a">
<center>
<% List <User> list=(List<User>)session.getAttribute("customerlist"); %>
<h1>Customers</h1>
<table border="1">
 <tr>
 <th>Id</th>
 <th>Name</th>
 <th>Email</th>
 <th>Mobile</th>
 </tr>
 <%for(User p:list){ %>
 		<tr>
 		<th><%=p.getId() %></th>
 		<th><%=p.getName() %></th>
 		<th><%=p.getEmail() %></th>
 		<th><%=p.getMobile() %></th>
 		
 		</tr>
 		<%}%>
 		
</table>
<br>  </center>
</div> <br>	
<center><a href="admin_home.html"><button>Back</button></a></center>
</body>
</html>
