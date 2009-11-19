<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<title>Users Information</title>
</head>
<body>

<table border="1">
	<thead>
		<tr bgcolor="#C0C0C0">
			<td>Name</td>
			<td>Last logged in at</td>
			<td>Is account locked?</td>
		</tr>
	</thead>
	<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.name}</td>
			<td>${user.lastLoggedInAt}</td>
			<td>${user.locked}</td>
		</tr>
	</c:forEach>
</table>