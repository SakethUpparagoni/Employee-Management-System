<%@ page import="com.EmployeeManagementSystem.entity.Employee"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Updating Password</title>
</head>
<body>
	
<% Employee employee = (Employee) request.getAttribute("employee");  %>
	
	<h2>
		<font color="green">Hii! your Password Has Been Updated
		</font>
	</h2>
	<a href="login">Login Again Using New Password Thank
		You !</a>
	<br>
	


</body>
</html>