<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
<title>Mini Twitter | User Registration</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/site_media/style.css" type="text/css" />
<script type="text/javascript">
function validateForm() { 
	var email = document.forms[0].email.value;
	var pwd1 = document.forms[0].password1.value;
	var pwd2 = document.forms[0].password2.value;
	var re = /\S+@\S+\.\S+/;
    if(pwd1!=pwd2){
    	alert("password not match");
    	return false;
    }
    if(!re.test(email)){
    	alert("email not valid");
    	return false;
    }
    document.forms[0].submit();
    return true;
}
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="header1.jsp" />		
		<h1>User Registration</h1>
		<form method="post" action=".">
			<div style='display: none'>
				<input type='hidden' name='csrfmiddlewaretoken' value='b74e3c6367d6328d9e8733a88f07c647' />
			</div>
			<p>
				<label for="id_username">Username:</label> 
				<input name="username" maxlength="30" type="text" id="id_username" />
			</p>
			<p>
				<label for="id_email">Email:</label> 
				<input name="email" type="text" id="id_email" />
			</p>
			<p>
				<label for="id_password1">Password:</label> 
				<input name="password1" type="password" id="id_password1" />
			</p>
			<p>
				<label for="id_password2">Password (Again):</label> 
				<input name="password2" type="password" id="id_password2"/>
			</p>

			<input type="submit" value="Register" />

			<input type="button" value="Regist" onclick="validateForm()"/>

		</form>

	</div>
</body>
</html>