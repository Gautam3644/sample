<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="1">
		<tr>
			<th>partNo</th>
			<th>name</th>
			<th>car model</th>
			<th>price</th>
			<th>quantity</th>
		</tr>
		<c:forEach items="${ listOfCarParts }" var="c">
			<tr>
				<td>${c.partno }</td>
				<td>${c.name }</td>
				<td>${c.carModel }</td>
				<td>${c.price }</td>
				<td>${c.quantity }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
