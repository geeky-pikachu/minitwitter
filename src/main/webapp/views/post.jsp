<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Mini Twitter | Home</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/site_media/style.css"
	type="text/css" />
</head>
<body>
	<div class="container">
		<jsp:include page="header2.jsp" />
		<h1>Geeky Pikachu Twitter Clone</h1>
		<p>Welcome ${username}! Here you can store and share bookmarks!</p>
		<p>Hi ${username}! What is on your mind?</p>
		<form method="post">
			<div style='display: none'>
				<input type='hidden' name='csrfmiddlewaretoken' value='8be4ba9360e22ce22306b3719a673a9c' />
			</div>
			<p>
				<label for="id_content">Say it:</label>
				<textarea cols="40" rows="10" name="message" id="id_content" maxlength="140"></textarea>
			</p>
			<input type="submit" value="post" />
		</form>

		<c:if test="${not empty tweets}"><div class="message green">
			<c:forEach items="${tweets}" var="tweet" varStatus="t">
				<p>${tweet.username} - ${tweet.tweet}, ${tweet.time} <a href="${username}/delete/${t.index}">delete</a></p>
       		</c:forEach>
		</c:if>
	</div>
</body>
</html>