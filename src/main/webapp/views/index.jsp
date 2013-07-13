<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
<title>Mini Twitter | Home</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/STATIC_FAVICON/favicon.ico" type="image/x-icon">
<link rel="icon" href="${pageContext.request.contextPath}/ANIMATED_FAVICON/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/site_media/style.css" type="text/css"/>
</head>
<body>
<jsp:include page="header1.jsp" />
	<h1>Geeky Pikaju Mini Twitter Clone</h1>

	<p>Welcome anonymous user!
      You need to <a href="${pageContext.request.contextPath}/signin/">Sign in</a>
      before you can use this application.</p>
    <p>If you don't have an account, please <a href="${pageContext.request.contextPath}/register/">Sign up now!</a></p>

</body>
</html>