
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
<title>Mini Twitter | Registration Successful</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/site_media/style.css" type="text/css"/>
</head>
<body>
<div class="container">
		<jsp:include page="header1.jsp" />	
	<h1>
Registration Completed Successfully
</h1>
	
Thank you for registering. Your information has been
saved in the database. Now you can either
<a href="${pageContext.request.contextPath}/login/">login</a> or go back to the
<a href="${pageContext.request.contextPath}/">main page</a>.

</div>
</body>
</html>