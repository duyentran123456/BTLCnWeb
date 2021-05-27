<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="/WEB-INF/views/css/mycomment.css"%></style>
<style><%@include file="/WEB-INF/views/css/manageComment.css"%></style>
<link
	href="https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My comments</title>
</head>
<body>
	<jsp:include page="../navbartop.jsp"></jsp:include>
	<div class="logo-wrapper">
		<a href="" class="logo">Lazy Blog</a>
		<p class="slogan">A Blog For Lazy People</p>
	</div>
	<div class="main-wrapper">
		<h2>Comments</h2>
		<c:forEach var="comment" items = "${comments }">			
			<div class="comment">
				<a href="/cnweb/post?id=${comment.postId }">${comment.content }</a>
				<form action="/cnweb/user/comment" method=POST>
					<input type="text" value="${comment.id }" name="id" hidden="true">
					<input type="submit" value="Delete">
				</form>
			</div>				
		</c:forEach>	
	</div> <!-- end main-wrapper -->
</body>
</html>