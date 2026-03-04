<%@ page import="com.EmployeeManagementSystem.entity.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>

<% Employee employee = (Employee) request.getAttribute("employee");  %>


	<h2>
		<font color="green"> Welcome  <%= employee.getEmployeName()%> Registration Successfull..! 
		</font>
	</h2>
<a href="login">Please Login  Thank
		You !</a>


</body>
</html>