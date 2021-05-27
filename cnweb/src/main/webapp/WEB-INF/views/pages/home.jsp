<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<style><%@include file="/WEB-INF/views/css/home.css"%></style>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home</title>
</head>
<body>
	<jsp:include page="navbartop.jsp"></jsp:include>
	<jsp:include page="logo.jsp"></jsp:include>
	<div class="main-wrapper">
	<h1>Recent Blogs</h1>
	<br>
		<div class="main-content">
			<c:forEach var="post" items = "${posts}">
				<div class="preview-blog">
					<div class="post-title">
					<a href="/cnweb/post?id=${post.id }">${post.title}</a>						
					</div>
					<div class="post-content">
						${post.content }
					</div>
				</div>
			</c:forEach>				
		</div>
		<jsp:include page="side-bar.jsp" />
	</div>
</body>
</html>