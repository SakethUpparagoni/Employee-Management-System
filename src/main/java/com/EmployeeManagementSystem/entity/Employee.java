package com.EmployeeManagementSystem.entity;

public class Employee {

	private int employeId;
	private String employeName;
	private String employeMail;
	private String loginPassword;
	private String newPassword;
	private String roleOfEmployee;

	public Employee() {
		System.out.println("Employeee Constructor");
	};

	public Employee(int empoyeId, String employeName, String employeMail, String loginPassword) {
		this.employeId = empoyeId;
		this.employeName = employeName;
		this.employeMail = employeMail;
		this.loginPassword = loginPassword;
	}

	public int getEmployeId() {
		return employeId;
	}

	public String getEmployeName() {
		return employeName;
	}

	public String getEmployeMail() {
		return employeMail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public String getNewpassword() {
		return newPassword;
	}

	public String getRoleOfEmployee() {
		return roleOfEmployee;
	}

	public void setEmployeeId(int empID) {
		this.employeId = empID;
	}

	public void setEmployeName(String employeName) {
		this.employeName = employeName;
	}

	public void setEmployeMail(String employeMail) {
		this.employeMail = employeMail;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public void setNewPassword(String newpassword) {
		this.newPassword = newpassword;
	}

	public void setRoleOfEmployee(String roleOfEmployee) {
		this.roleOfEmployee = roleOfEmployee;
	}

}
