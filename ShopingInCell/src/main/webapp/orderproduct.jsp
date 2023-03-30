<%@page import="dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Place your Order</title>
<link rel="stylesheet" href="background.css">
<style>
	body{
		border:2px solid black;
		padding:125px;
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
		margin-left:300px;
		
	}
	button{
		height:25px;
		width:87.15px;
		margin-left:80px;
	}
	button:hover{
		background-color:white;
		color:black;
	}
	form{
		text-align:center;
		margin:auto;
		display:inline-block;
	}
	table{
		
		align-items:center;
		margin:auto;
	}

</style>
</head>
<body>
<form action="placeorder">
<h1 style="margin-left:300px;">Place your Order</h1>
<div class="a">
<% List <Product> list=(List<Product>)session.getAttribute("productlist"); %>
<h1>Products</h1>
<table border="1">
 <tr>
 <th>Name</th>
 <th>Category</th>
 <th>Price</th>				
 <th>Select</th>
 </tr>
 <%char ch='a'; %>
 <%for(Product p:list){ %>
 		<tr>
 		<th><%= p.getName() %></th>
 		<th><%= p.getCategory() %></th>
 		<th><%= p.getPrice() %></th>
 		<th><input type="checkbox" value="<%=p.getId() %>" name="<%=ch++%>"></th>
 		</tr>
 		<%}%>		
</table> <br>
</div> <br>
<button>Place Order</button>
 </form>
<a href="customer_home.html"><button style="margin-left:-150px;">Back</button></a>
</body>
</html>