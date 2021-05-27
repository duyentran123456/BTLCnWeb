<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="/WEB-INF/views/css/login.css"%></style>
<link
	href="https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300&display=swap"
	rel="stylesheet">
<title>Login</title>
</head>
<body>
	<div class="topbar">
		<a href="/cnweb" class="brand">Lazy Blog</a>
	</div>
	<div class="login">
		<h2>Login</h2>
		<form class="form-login"
			action="${pageContext.request.contextPath}/login" method="POST">
			<input class="input" type="text" name="username" id="username"
				placeholder="username" required>
			<input class="input" type="password"
				name="password" id="password" placeholder="password" required>
			<div align='center' id='errorText'>${message }</div>
			<input class="btn-submit" id="btnLogin" type="submit" value="Submit">
			<label> <input type="checkbox" name="remember" value="on"> <span>Remember
					Me</span>
			</label>
		</form>
		<br>
		<a href="/cnweb/register">Create an account</a>
		
	</div>
	

</body>
</html>