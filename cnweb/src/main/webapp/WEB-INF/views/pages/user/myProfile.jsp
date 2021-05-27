<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/views/css/Myprofile1.css"%></style>
<link href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Profile</title>
</head>
<body>
	<jsp:include page="../navbartop.jsp"></jsp:include>
	<jsp:include page="../logo.jsp"></jsp:include>
	<div class="main-wrapper">
		<div class="main-content">
			<div class="author-avatar"><img src="https://via.placeholder.com/150" alt=""></div>
            <div class="author-name"><c:out value="${sessionScope.user.name }" default="Unknown name"></c:out></div>
            <span class="material-icons-outlined" >local_florist</span>
            
            <h2>Information</h2>
            <form action="/cnweb/user/profile" method="POST">
            	<div class="full_name">
                    <p style="font-weight: bold;">Full name</p>
                    <input type="text" class="information" name="name" value="${sessionScope.user.name }">
                    <hr>
                </div>
                <div class="about">
                    <p style="font-weight: bold;">About</p>
                    <input type="text" class="information" name="about" value="${sessionScope.user.about }">
                    <hr>
                </div>            
            	<input type="submit" value="Update">            	
            </form>
		</div>
	</div>
</body>
</html>