<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${sessionScope.user != null }">
		<jsp:include page="navbartop_user.jsp"></jsp:include>
	</c:when>
	<c:when test="${sessionScope.admin != null }">
		<jsp:include page="navbartop_admin.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="navbartop_guest.jsp"></jsp:include>
	</c:otherwise>
</c:choose>