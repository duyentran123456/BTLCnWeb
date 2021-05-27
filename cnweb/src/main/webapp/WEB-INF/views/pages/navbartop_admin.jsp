<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<style><%@include file="/WEB-INF/views/css/navbar2.css"%></style>
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
			<div class="dropdown">
				<button class="dropbtn">
					Admin <span class="material-icons-outlined">keyboard_arrow_down</span>
				</button>
				<div class="dropdown-content">
					<a href="/cnweb/admin/post">Post Manager</a> <a href="/cnweb/admin/comment">Comment Manager</a> <a
						href="/cnweb/admin/logout">Log Out</a>
				</div>
			</div>
		</div>
		<!-- end nav-right -->
	</div>
</div>
