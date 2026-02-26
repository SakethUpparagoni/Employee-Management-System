<%@ page import="com.EmployeeManagementSystem.service.EmployeeService"%>
<%! EmployeeService  employeeService = new EmployeeService();%>


<%
String idParam = request.getParameter("empId");
String empMail = request.getParameter("empMail");

if (idParam != null && empMail != null) {

	int empId = Integer.parseInt(idParam);

	boolean deletedStatus = employeeService.removeEmployee(empId, empMail);

	if (deletedStatus) {
%>
<h3 style="color: green">Employee Deleted Successfully</h3>
<a href="EmployeeList.jsp">Go Back</a>
<%
} else {
%>
<h3 style="color: red;">Failed to Delete Employee</h3>
<a href="EmployeeList.jsp">Go Back</a>
<%
}

} else {
%>
<h3 style="color: red;">Invalid Request</h3>
<%
}
%>