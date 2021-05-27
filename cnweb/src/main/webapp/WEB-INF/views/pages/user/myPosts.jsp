<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/views/css/mypost.css"%></style>
<style><%@include file="/WEB-INF/views/css/managePost.css"%></style>
<link
	href="https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Posts</title>
</head>
<body>
	<jsp:include page="../navbartop.jsp"></jsp:include>
	<div class="logo-wrapper">
		<a href="" class="logo">Lazy Blog</a>
		<p class="slogan">A Blog For Lazy People</p>
	</div>
	<div class="main-wrapper">
		<h2>My posts</h2>
		<c:forEach var="post" items="${posts }">
			<div class="post-title">
				<a href="/cnweb/post?id=${post.id }" title="">${post.title }</a>
				<form action="/cnweb/user/post/edit" method="GET">
					<input type="text" value="${post.id }" name="id" hidden="true">
					<input type="submit" value="Edit">
				</form>
				<form action="/cnweb/user/post" method=POST>
					<input type="text" value="${post.id }" name="id" hidden="true">
					<input type="submit" value="Delete">
				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html>