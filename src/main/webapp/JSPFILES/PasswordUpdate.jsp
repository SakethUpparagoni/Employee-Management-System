<%@ page import="com.EmployeeManagementSystem.entity.Employee"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.EmployeeManagementSystem.service.EmployeeService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Updating Password</title>
</head>
<body>
	<%! EmployeeService  employeeService = EmployeeService.getInstance();%>

	<jsp:useBean class="com.EmployeeManagementSystem.entity.Employee" id="employee" scope="session" />
	<jsp:setProperty name="employee" property="employeMail" param="emadd" />
	<jsp:setProperty name="employee" property="loginPassword" param="oldpass" />
	<jsp:setProperty name="employee" property="newPassword" param="newPass" />


	<%
	boolean changingStatus = employeeService.changeEmployeePassword(employee);

	if (changingStatus) {
	%>

	<h2>
		<font color="green">Hii! <jsp:getProperty name="employee"
				property="employeName" /> your Password Has Been Updated
		</font>
	</h2>
	<a href="../HTML/Login.html">Login Again Using New Password Thank
		You !</a>
	<br>
	<%
	} else {
	%>

	<h2>
		<font color="red"> There is an Error Updating the password</font>
	</h2>

	<a href="../HTML/ChangePassword.html">Try Again</a>
	<%
	}
	%>


</body>
</html>