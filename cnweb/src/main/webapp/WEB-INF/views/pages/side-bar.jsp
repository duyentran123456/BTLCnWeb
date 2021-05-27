<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="side-bar">
	<p>Tags:</p>
	<br>
	<c:forEach var="tag" items="${tags }">
		<div class="tag-name">
			<a href="/cnweb/tag?id=${tag.id }" class="icon-tag"> <span
				class="material-icons-outlined">tag</span> <span class="name-tag">${tag.name}</span>
			</a>
		</div>
		<br>
	</c:forEach>
</div>