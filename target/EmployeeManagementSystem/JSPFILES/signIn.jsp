<%@ page import="com.EmployeeManagementSystem.entity.Employee"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.EmployeeManagementSystem.service.EmployeeService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
<%! EmployeeService  employeeService = EmployeeService.getInstance();%>

	<jsp:useBean class="com.EmployeeManagementSystem.entity.Employee" id="employee" scope="session" />
	<jsp:setProperty name="employee" property="employeMail" param="emadd" />
	<jsp:setProperty name="employee" property="loginPassword" param="pass" />


	<%
	boolean signInStatus = employeeService.loginEmployee(employee);

	if (signInStatus) {
	%>

	<h2>
		<font color="green"> Welcome <jsp:getProperty name="employee"
				property="employeName" />
		</font>
	</h2>
	
	<a href="../HTML/ChangePassword.html">Update Password</a> <br>
	<a href="../HTML/ChangeEmail.html">Update Email</a>
	<a href="./EmployeeList.jsp">Employee List</a>
	<%
	} else {
	%>

	<h2>
		<font color="red"> Invalid Access </font>
	</h2>

	<a href="../HTML/Login.html">Try Again</a>
	<%
	}
	%>


</body>
</html>