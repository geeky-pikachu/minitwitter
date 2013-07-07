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
		<div id="nav">
			<a href="/">Home</a> | <a href="/users/">Users</a> | <a
				href="/logout/">Sign out</a>

		</div>
		<h1>Geeky Pikachu Twitter Clone</h1>


		<p>Welcome xxxx! Here you can store and share bookmarks!</p>

		<p>Hi xxxx! What is on your mind?</p>
		<form method="post">
			<div style='display: none'>
				<input type='hidden' name='csrfmiddlewaretoken'
					value='8be4ba9360e22ce22306b3719a673a9c' />
			</div>
			<p>
				<label for="id_content">Say it:</label>
				<textarea cols="40" rows="10" name="message" id="id_content"
					maxlength="140"></textarea>
			</p>
			<input type="submit" value="post" />
		</form>

		<table class="microposts">

		</table>



	</div>
</body>
</html>