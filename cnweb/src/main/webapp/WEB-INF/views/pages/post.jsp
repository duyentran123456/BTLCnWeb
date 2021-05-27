<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/views/css/post.css"%></style>
<style><%@include file="/WEB-INF/views/css/side-bar.css"%></style>
<title><c:out value="${post.title}"
		default="This post does not exist" /></title>
</head>
<body>

	<jsp:include page="navbartop.jsp"></jsp:include>
	<div class="logo-wrapper">
		<a href="" class="logo">Lazy Blog</a>
		<p class="slogan">A Blog For Lazy People</p>
	</div>
	<div class="main-wrapper">
	<jsp:include page="side-bar.jsp"/>
		<div class="content-wrapper">
			<div class="post">
				<div class="post-title">
					<h2>
						${post.title }
					</h2>
				</div>
				<div class="post-content">
					<p>${post.content }</p>					
				</div>
				<c:if test = "${prevId != null}">
         			<a href="/cnweb/post?id=${prevId }">Previous post</a>
      			</c:if>
      			<c:if test = "${nextId != null}">
         			<a href="/cnweb/post?id=${nextId }">Next post</a>
      			</c:if>					
			</div>
			<div class="author">
				<div class="author-avatar">
					<img src="https://via.placeholder.com/150" alt="author avatar">
					
				</div>
				<div class="author-information">
					<h2 class="author-name">
						<c:out value="${author.name }" default="Unknown name author"/>
					</h2>
					<p>
						${author.about }
					</p>
				</div>
			</div>
			<div class="comment">
				<div class="comment-wrapper">
					<form action="${pageContext.request.contextPath}/user/comment/create" class="leave-a-reply" method="POST">
						<h2 class="leave-a-reply">Leave a Reply</h2>
						<input type="text" name="postId" value="${post.id }" hidden="true">
						<p>Comment</p>
						<textarea id="comment" name="content" rows="2" required="required"></textarea>
						<p class="comment-submit">
							<input type="submit" value="Submit">
						</p>
					</form>
					<div class="previous-comments">
						<h2 class="leave-a-reply">Comments</h2>
						<c:forEach var="comment" items = "${comments}">
							<p class="previous-comment">${comment.content}</p>
							<hr>
						</c:forEach>
					</div>
				</div>
			</div>
		</div> <!-- end content-wrapper -->
		
	</div> <!-- end main-wrapper -->
</body>
</html>