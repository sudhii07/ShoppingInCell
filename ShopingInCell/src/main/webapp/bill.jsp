<%@page import="dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
<link rel="stylesheet" href="background.css">
<style>
	body{
		border:2px solid black;
		padding:160px;
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
	}
	button{
		height:25px;
		width:100px;
	}
	button:hover{
		background-color:white;
		color:black;
	}

</style>
</head>
<body>
<center>
<%double sum=0; %>
<h1>Bill</h1>
<div class="a">
<%List<Product> products=(List<Product>)session.getAttribute("products"); %>
<table>
<tr>
<th>Your order are:- </th>
</tr>
<%for(Product product:products){ %>
	<tr>
	<th><%=product.getName() %></th>
	<th><%=product.getPrice() %></th>
	</tr>
	<%sum=sum+product.getPrice(); %>
	<%} %>
	<tr>
	<th>Your total bill amount is:<%=sum%></th>
	</tr>
</table>
</div> <br>
<button onclick="window.print()">Print bill</button>
<a href="orderproduct.jsp"><button>Back</button></a>
 </center>
</body>
</html>