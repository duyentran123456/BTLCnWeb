<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<style><%@include file="/WEB-INF/views/css/createPost.css"%></style>
	<link href="https://fonts.googleapis.com/css2?family=Press+Start+2P&amp;display=swap" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Creating a post</title>
</head>
<body>
	<jsp:include page="../navbartop.jsp"></jsp:include>
	<div class="post">
		<div class="post-wrapper">
			<form action="/cnweb/user/post/create" class="leave-a-post" method="POST">
				<h2 class="leave-a-post">Create a post</h2>
				<p>Create Post</p>
                      <div class="title">
                          <textarea id="title" name="title" rows="1" placeholder="title" required="required"></textarea>
                      </div>
                      <div class="content">
                          <textarea id="content" name="content" rows="2" placeholder="content" required="required"></textarea>
                      </div>
				<div class="post-submit">
                     <input type="submit" value="Create">
                     <input type="reset" value="Cancel">
				</div>
			</form>
		</div>
	</div>
</body>
</html>