<%@page import="dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="background.css">
<style>
	body{
		border:2px solid black;
		padding:137px;
		margin:10px;
		background-size:cover;
	}
	button{
		background-color:red;
	}
	body .a {
		border:5px solid black;
		width:400px;
		height:auto;
		margin:auto;
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
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
<div class="a">
<center>
<% List <Product> list=(List<Product>)session.getAttribute("productlist"); %>
<h1>Products</h1>
<table border="1">
 <tr>
 <th>ID</th>
 <th>Name</th>
 <th>Price</th>
 <th>Category</th>				
 <th>Edit</th>
 <th>Delete</th>
 </tr>
 <%for(Product p:list){ %>
 		<tr>
 		<th><%= p.getId() %></th>
 		<th><%= p.getName() %></th>
 		<th><%= p.getPrice() %></th>
 		<th><%= p.getCategory() %></th>
 		<th><a href="update.jsp?id=<%=p.getId()%>"><button>EDIT </button></a></th>
 		<th><a href="deleteProduct?id=<%=p.getId()%>"><button>DELETE </button></a></th>
 		</tr>
 		<%}%>
 		
</table>
<br>
</div> <br>
<center><a href="admin_home.html"><button>Back</button></a></center>
</body>
</html>