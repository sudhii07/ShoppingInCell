<%@page import="dto.Product"%>
<%@page import="dao.productdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update product</title>
<link rel="stylesheet" href="background.css">
<style>
	body{
		border:2px solid black;
		padding:140px;
		margin:8px;
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
		height:28px;
		width:60px;
	}
	button:hover{
		background-color:white;
		color:black;
	}

</style>
</head>
<body>
<%int id=Integer.parseInt(request.getParameter("id"));
productdao dao=new productdao();
Product product=dao.fetchproduct(id);
%>
<div class="a">
<center>
<h1>Edit Product</h1>
<form action="update" method="post">
Id:<input type="text" name="id" value="<%=product.getId()%>" readonly="readonly"><br><br>
Name:<input type="text" name="name" value="<%=product.getName()%>"><br><br>
Category:<input type="text" name="category" value="<%=product.getCategory()%>"><br><br>
Price:<input type="text" name="price" value="<%=product.getPrice()%>"><br><br>
<button>Update</button> <br> <br> 
</form>
</center>
</div> <br>
<center><button type="reset">Cancel</button>
<a href="fetchproducts.jsp"><button>Back</button></a> <br> <br></center>
</body>
</html>