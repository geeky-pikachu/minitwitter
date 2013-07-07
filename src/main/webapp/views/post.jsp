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
<<<<<<< HEAD
		<table class="microposts">
			<c:forEach items="${tweets}" var="tweet">
		  <tr>
	    <td colspan="50">
	      <span class="user">
	        <a href="${pageContext.request.contextPath}/${tweet.username}">${tweet.username}</a>
	      </span>
	      <span class="content"><pre>${tweet.tweet}</pre>
			</span>
	      <span class="timestamp">${tweet.time}
	        </span>
	   		 </td>
	    
		    <td colspan="3">	      
		         <a href="${username}/delete/${t.index}">delete</a>	      
		    </td>
		
	  </tr>

		     </c:forEach>
       		 </table>
		</c:if>
	</div>
</body>
</html>