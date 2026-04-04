<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		Email address: <input type="text" name="emadd" value="${email}"> <br>
		Password: <input type="password" name="pass"><br>
		<button type="submit">Login</button>
	</form>
	<p style="color: ${status == 'success' ? 'green' : 'red'};">
		${message}</p>

	<p style="color: green">${msg}</p>
	
	<%
	session.removeAttribute("msg");
	session.removeAttribute("email");
	%>
	<form action="home" method="get">
		<button type="submit">Home</button>
	</form>
</body>
</html>