<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
<title>Mini Twitter | User Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/site_media/style.css" type="text/css"/>
</head>
<body>
<jsp:include page="header1.jsp" />
	<h1>User Login</h1>
	
	<form method="post" action="."> 
		<div style='display:none'><input type='hidden' name='csrfmiddlewaretoken' value='b74e3c6367d6328d9e8733a88f07c647' /></div>
		<p><label for="id_username">Username:</label>
			<input name="username" maxlength="30" type="text" id="id_username" /></p>
		<p><label for="id_password">Password:</label>
			<input name="password" type="password" id="id_password" /></p>
			<input type="submit" value="Login" />
			<input type="hidden" name="next" value="/" />
	</form>
</body>
</html>