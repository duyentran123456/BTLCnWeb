<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<style><%@include file="/WEB-INF/views/css/navbar3.css"%></style>
<link
	href="https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined"
	rel="stylesheet">
<div class="navbar">
	<div class="navbar-top">
		<div class="nav nav-left">
			<div class="logo">
				<a href="/cnweb" class="logo">Lazy Squad</a>
			</div>
		</div>
		<div class="nav nav-center">
			<nav>
				<a href="/cnweb">Home</a> <a href="/cnweb/tag">Tags</a> <a href="/cnweb/about">About</a>
			</nav>
		</div>
		<!-- end nav-center -->
		<div class="nav nav-right">
			<div class="add-post">
				<a class="new-post" href="/cnweb/user/post/create"> <span
					class="material-icons-outlined">add</span> <span
					class="new-post-btn-text">New Post</span>
				</a>

			</div>
			<div class="dropdown">
				<button class="dropbtn">
					<span class="material-icons-outlined">account_circle</span>
				</button>
				<div class="dropdown-content">
					<a href="/cnweb/user/profile">My Profile</a> <a href="/cnweb/user/comment">My Comment</a> <a href="/cnweb/user/post">My
						Posts</a> <a href="/cnweb/user/logout">Log Out</a>
				</div>
			</div>
		</div>
		<!-- end nav-right -->
	</div>
</div>
