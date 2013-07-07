<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
<title>Mini Twitter | Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/site_media/style.css" type="text/css"/>
</head>
<body>
<div class="container">
	<div id="nav">
		<a href="${pageContext.request.contextPath}/">Home</a> |
		
			<a href="${pageContext.request.contextPath}/login/">Sign in</a>
		
	</div>
	<h1>Geeky Pikaju Mini Twitter</h1>
	

	<p>Welcome anonymous user! 
      You need to <a href="${pageContext.request.contextPath}/login/">Sign in</a> 
      before you can use this application.</p>
    <p>If you don't have an account, please <a href="${pageContext.request.contextPath}/users/register/">Sign up now!</a></p>


</div>
</body>
</html>