<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<style><%@include file="/WEB-INF/views/css/tag.css"%></style>
	<link href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tag info</title>
</head>
<body>
	<jsp:include page="navbartop.jsp"></jsp:include>
	<jsp:include page="logo.jsp"></jsp:include>
	<div class="main-wrapper">
		<div class="main-content">
			<c:choose>
				<c:when test="${tag != null}">
					<h2>${tag.name }</h2>
					<p>Posts that have ${tag.name } tag:</p>
					<c:choose>
						<c:when test="${posts != null}">
							post != null
							<c:forEach var="post" items="${posts }">
								<div class="_1post">
									<div class="post-title">
										<span class="material-icons-outlined">emoji_nature</span>
										<h3>${post.title }</h3>
									</div>
									<div class="post-content">${post.content }</div>
								</div>
								
							</c:forEach>
						</c:when>
						<c:otherwise>
							<p class="no-post">There is no post</p>
						</c:otherwise>
					</c:choose>
				</c:when>

				<c:otherwise>
					<p class="no-tag">There is no such tag!</p>
				</c:otherwise>
			</c:choose>
		</div> <!-- end main-content -->
		<!-- sidebar -->
	</div>
</body>
</html>