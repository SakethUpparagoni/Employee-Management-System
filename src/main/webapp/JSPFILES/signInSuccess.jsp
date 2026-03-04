<%@ page import="com.EmployeeManagementSystem.entity.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>

	<%
	Employee employee = (Employee) session.getAttribute("employee");
	if (employee == null) {
		response.sendRedirect("../home");
		return;
	}
	%>


	<h2>
		<font color="green"> Welcome <%=employee.getEmployeName()%>
		</font>
	</h2>
	<a href="passwordUpdate">Update Password</a>
	<br>
	<a href="../HTML/ChangeEmail.html">Update Email</a><br>
	<a href="empList">Employee List</a><br>
	<form action="logout">
	<button type="submit">Logout</button></form>
	


</body>
</html>