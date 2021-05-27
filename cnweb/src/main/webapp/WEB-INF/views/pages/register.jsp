<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="/WEB-INF/views/css/register.css"%></style>
<link href="https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300&display=swap" rel="stylesheet">
<title>Register</title>
</head>
<body>
	<div class="topbar">
		<a href="/cnweb" class="brand">Lazy Blog</a>
	</div>
	<div class="register">
		<h2>Register</h2>
		<form class="form-register" action="${pageContext.request.contextPath}/register" method="POST" onsubmit="return registerForm()">
			<input class="input" type="text" name="username" id="username" placeholder="username" required>
			<input class="input" type="password" name="password" id="password" placeholder="password" required>
			<input class="input" type="password" name="repeat password" id="repeat_password" placeholder="repeat password" required>
			<div align='center' id='errorText'>${message }</div>
			<input class="btn-submit" id="btnRegister" type="submit" value="Submit">
		</form>
	</div>

	<script>function registerForm()
	{
	    // Bước 1: Lấy giá trị 
	    var username = document.getElementById('username').value;
	    var password = document.getElementById('password').value;
	    var repeat_password = document.getElementById('repeat_password').value;
	 
	    // Bước 2: Kiểm tra dữ liệu hợp lệ hay không
	    if (username == ''){
	        alert('You need to fill username field');
	    }
	    else if (password == '')
	    {
	        alert('You need to fill password field');
	    }
	    else if (password != repeat_password)
	    {
	    	alert('Repeated password must equal password');
	    }
	    else{
	        return true;
	    }
	 
	    return false;
	}</script>
	
</body>
</html>