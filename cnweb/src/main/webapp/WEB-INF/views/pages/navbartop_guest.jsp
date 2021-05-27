<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined" rel="stylesheet">
<style><%@include file="/WEB-INF/views/css/navbartop.css"%></style>
<div class="navbar">
<div class="navbar-top">
	<div class="nav nav-left">
		<input type="text" name="search"> <a href="" title=""><span
			class="material-icons-outlined search">search</span></a>

	</div>
	<div class="nav nav-center">
		<nav>
			<a href="/cnweb/home">Home</a> <a href="/cnweb/tag">Tags</a> <a
				href="/cnweb/about">About</a>
		</nav>
	</div>
	<div class="nav nav-right">
		<a href="/cnweb/login" title="">Login</a>
	</div>
</div>
</div>