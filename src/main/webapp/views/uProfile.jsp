
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
<title>Mini Twitter | {username}</title>
<link rel="stylesheet" href="/site_media/style.css" type="text/css" />
</head>
<body>
	<div class="container">
		<jsp:include page="header2.jsp" />	
		<h1>{username}</h1>




		<table class="info">
			<tr>
				<td colspan="3"><b>Name</b> {username}</td>
			</tr>
			<tr>
				<td colspan="3"><b>URL</b> <a href="${pageContext.request.contextPath}/users/15/">/users/{userId}/</a>
				</td>
			</tr>
			<tr>
				<td colspan="3"><b>Microposts</b> {countPost}</td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/users/15/followings/">{countFollowings} Followings</a></td>
				<td>|</td>
				<td><a href="${pageContext.request.contextPath}/users/15/followers/">{countFollowers} Followers</a></td>
			</tr>
		</table>

		<table class="microposts">

			<tr>
				<td>
				<span class="content">Helllo pika </span>
				 <span class="timestamp">Posted July 6, 2013, 10:48 p.m.</span>
				 </td>
			</tr>

		</table>


	</div>
</body>
</html>