<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<style><%@include file="/WEB-INF/views/css/update.css"%></style>
	<link href="https://fonts.googleapis.com/css2?family=Press+Start+2P&amp;display=swap" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Edit post</title>
</head>
<body>
	<div class="post">
		<div class="post-wrapper">
			<form action="/cnweb/user/post/edit" class="leave-a-post" method="POST">
				<h2 class="leave-a-post">Edit post</h2>
				<p>Edit Post</p>
                      <div class="title">
                          <textarea id="title" name="title" rows="1" placeholder="title">${post.title }</textarea>
                      </div>
                      <div class="content">
                          <textarea id="content" name="content" rows="2" placeholder="content" required="required">${post.content }</textarea>
                      </div>
				<p class="post-submit">
						<input type="text" name="id" value="${post.id }" hidden="true">
                        <input type="submit" value="Update">
                        <input type="reset" value="Canel">
                </p>
			</form>
		</div>
	</div>
</body>
</html>