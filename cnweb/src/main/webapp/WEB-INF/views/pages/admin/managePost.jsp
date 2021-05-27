<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/views/css/managePost.css"%></style>
<link href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Manage Posts</title>
</head>
<body>
	<jsp:include page="../navbartop.jsp"></jsp:include>
	<jsp:include page="../logo.jsp"></jsp:include>
	<div class="main-wrapper">
		<h2>All posts</h2>
		<c:forEach var="post" items = "${posts }">
			<div class="post-title">
				<a href="/cnweb/post?id=${post.id }" title="">${post.title }</a>
				<form action="/cnweb/admin/post" method=POST>
					<input type="text" value="${post.id }" name="id" hidden="true">
					<input type="submit" value="Delete">
				</form>
			</div>			
		</c:forEach>
	</div>
</body>
</html>