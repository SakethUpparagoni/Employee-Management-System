<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="signUp" method="post">
		Employee Name: <input type="text" name="empName"> <br>
		Employee Role: <input type="text" name="emprole"> <br>
		Email address: <input type="text" name="emadd"> <br>
		Password: <input type="password" name="pass"><br>
		<button type="submit">Sign Up</button>
	</form>

	<p style="color: red">${message}</p>
	
	<form action="home" method="get">
		<button type="submit">Home</button>
	</form>
</body>
</html>