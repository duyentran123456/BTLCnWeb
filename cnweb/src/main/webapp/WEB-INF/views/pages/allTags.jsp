<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/views/css/alltag.css"%></style>
<link
	href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>All tags info</title>
</head>
<body>
	<jsp:include page="navbartop.jsp"></jsp:include>
	<jsp:include page="logo.jsp"></jsp:include>
	<div class="main-wrapper">
		<c:choose>
			<c:when test="${tags != null}">
				<c:forEach var="tag" items="${tags }">
					<div class="tag-name">
					<a href="/cnweb/tag?id=${tag.id}">${tag.name }</a>
					</div>
				</c:forEach>
			</c:when>
	
			<c:otherwise>
				<p>There is no tags in this blog :></p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>