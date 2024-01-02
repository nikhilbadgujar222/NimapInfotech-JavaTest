<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact List - Spring Boot Web Application Example</title>
</head>
<body>
<h1 align="center">Product Data Table</h1>
<br />
<table border="1" cellpadding="10">
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Quantity</th>
<th>Product Manafacturer</th>
</tr>
<c:forEach var="data" items="${productlist}">
<tr>
<td>${data.productId}</td>
<td>${data.productName}</td>
<td>${data.productQty}</td>
<td>${data.manafacturer}</td>
</tr>
</c:forEach>
</table>
</body>
</html>