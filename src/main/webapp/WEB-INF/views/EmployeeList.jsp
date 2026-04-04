<%@ page import="com.EmployeeManagementSystem.entity.Employee"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.EmployeeManagementSystem.service.EmployeeService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Employee Email</th>
			<th>Employee Password</th>
			<th>Employee Role</th>
			<th>Delete Or Edit</th>

		</tr>

		<%
		Employee loggedUser = (Employee) session.getAttribute("employee");
		%>

		<%
		ArrayList<Employee> employeList = (ArrayList<Employee>) request.getAttribute("employees");
		for (Employee emp : employeList) {
		%>


		<tr>
			<td><%=emp.getEmployeId()%></td>
			<td><%=emp.getEmployeName()%></td>
			<td><%=emp.getEmployeMail()%></td>
			<td><%=emp.getLoginPassword()%></td>
			<td><%=emp.getRoleOfEmployee()%></td>

			<td><a href="editEmployee?empId=<%=emp.getEmployeId()%>">Edit</a>

				<%
				if (loggedUser != null && "Admin".equals(loggedUser.getRoleOfEmployee())) {
				%> | <a href="deleteEmployee?empId=<%=emp.getEmployeId()%>"
				onclick="return confirm('Are you sure you want to delete this employee?');">
					Delete </a> <%
 }
 %></td>
		</tr>
		<%
		}
		%>
	</table>
	<form action="home" method="get">
		<button type="submit">Home</button>
	</form>
</body>
</html>