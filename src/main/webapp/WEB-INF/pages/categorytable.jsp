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
<h1 align="center">Category Table Data</h1>
<br />
<table border="1" cellpadding="10">
<tr>
<th>Category Id</th>
<th>Category Name</th>
<th>Category Description</th>

</tr>
<c:forEach var="data" items="${categoryList}">
<tr>
<td>${data.categoryId}</td>
<td>${data.categoryName}</td>
<td>${data.categoryDescp}</td>

</tr>
</c:forEach>
</table>
</body>
</html>