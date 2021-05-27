<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/views/css/users.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>All members of our website</title>
</head>
<body>
	<jsp:include page="navbartop.jsp"></jsp:include>
	<jsp:include page="logo.jsp"></jsp:include>
	<div class="main-wrapper">
		<div class="users">
			<h2>Users</h2>
			<c:forEach var="user" items="${users }">
				<div class="user">
					<div class="username"><a href="/cnweb/about?id=${user.id }">${user.username }</a></div>
					<div class="name">${user.name }</div>
					<div class="role">${user.role }</div>
				</div>
			</c:forEach>
		</div> <!-- end users -->
		
		<!-- sidebar -->
	</div>
</body>
</html>