<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updatePassword" method="post">
		Email address: <input type="text" name="employeeMail"> <br>
		OldPassword: <input type="password" name="oldPassword"><br>
		NewPassword: <input type="password" name="newPassword"><br>
		<button type="submit">Update</button>
	</form>
	<p style="color: ${status == 'success' ? 'green' : 'red'};">
		${message}</p>
</body>
</html>