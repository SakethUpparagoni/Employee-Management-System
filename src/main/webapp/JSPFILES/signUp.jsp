<%@ page import="com.EmployeeManagementSystem.entity.Employee"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.EmployeeManagementSystem.service.EmployeeService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Signing In</title>
</head>
<body>
	<%! EmployeeService  employeeService = EmployeeService.getInstance();%>

	<jsp:useBean class="com.EmployeeManagementSystem.entity.Employee" id="employee" />
	<jsp:setProperty name="employee" property="employeName" param="empName" />
	<jsp:setProperty name="employee" property="roleOfEmployee"
		param="emprole" />
	<jsp:setProperty name="employee" property="employeMail" param="emadd" />
	<jsp:setProperty name="employee" property="loginPassword" param="pass" />

	<%
	boolean signUpStatus = employeeService.signUpEmployee(employee);

	if (signUpStatus) {
	%>
	<h2>
		<font color="green"> Sign Up Successful. As <jsp:getProperty
				name="employee" property="roleOfEmployee" />
		</font>
	</h2>
	<a href="../HTML/Login.html">Login Again Using Credentials Thank You
		!</a>
	<br>
	<%
	} else {
	%>
	<h2>
		<font color="red"> Problem occurred during sign up. Please try
			again after sometime. </font>
	</h2>
	<%
	}
	%>
</body>
</html>