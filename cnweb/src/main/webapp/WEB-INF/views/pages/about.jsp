<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/views/css/about.css"%></style>
<link href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>About</title>
</head>
<body>
	<jsp:include page="navbartop.jsp"></jsp:include>
	<jsp:include page="logo.jsp"></jsp:include>
	<div class="main-wrapper">
		<div class="main-content">
		<c:choose>
			<c:when test="${author != null}">
				<div class="author-avatar"><img src="https://via.placeholder.com/150" alt=""></div>
				<div class="author-name"><c:out value="${author.name }" default="Unknown name"/></div>
				<div class="author-role">${author.role }</div>
				<div class="author-about">${author.about }</div>
				<c:forEach var="tag" items = "${posts }">
					<div class="tag-name">
						<span class="material-icons-outlined">local_florist</span>
						<a href="/cnweb/post?id=${post.id }">${post.title }</a>
					</div>
				</c:forEach>
			</c:when>
			
			<c:otherwise>
	   			<p class="no-information">There is no information</p>
	  		</c:otherwise>
	  		</c:choose>
		</div>
	</div>
</body>
</html>