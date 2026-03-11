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
	<%! EmployeeService  employeeService = EmployeeService.getInstance();%>
	
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
		ArrayList<Employee> employeList = employeeService.getAllEmployees();

		for (Employee emp : employeList) {
		%>

		<tr>
			<td><%= emp.getEmployeId() %></td>
			<td><%= emp.getEmployeName() %></td>
			<td><%= emp.getEmployeMail() %></td>
			<td><%= emp.getLoginPassword() %></td>
			<td><%= emp.getRoleOfEmployee() %></td>
			<td><a href="./JSPFILES/DeletEmp.jsp?empId=<%= emp.getEmployeId()%>&empMail=<%= emp.getEmployeMail() %>"> Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
		<a href="<%= request.getContextPath() %>/home"> Back to home</a>
</body>
</html>