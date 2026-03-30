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
		response.sendRedirect(request.getContextPath() + "/");

		return;
	}
	%>

	<h2>
		<font color="green"> Welcome <%=employee.getEmployeName()%>
		</font>
	</h2>
	<a href="passwordUpdate">Update Password</a>
	<br>
	<a href="emailUpdate">Update Email</a>
	<br>
	<br>
	<form action="logout" method="get">
		<button type="submit">Logout</button>
	</form>
	
	<script>
	let name = "${name}";
	if (name && name !== "") {
		alert("Welcom "+ name);
	}</script>



</body>
</html>