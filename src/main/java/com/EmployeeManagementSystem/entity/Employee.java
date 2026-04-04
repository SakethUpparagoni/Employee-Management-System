package com.EmployeeManagementSystem.entity;

import jakarta.persistence.Column; 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEEDATA")
public class Employee {

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "EmpId")
	private int employeId;

	@Column(name = "EmpName")
	private String employeName;

	@Column(name = "empEmail")
	private String employeMail;

	@Column(name = "empPassword")
	private String loginPassword;

	@Column(name = "role_of_emp")
	private String roleOfEmployee;

	public Employee() {
		System.out.println("Employeee Constructor");
	};

	public Employee(int empoyeId, String employeName, String employeMail, String loginPassword, String roleOfEmployee) {
		this.employeId = empoyeId;
		this.employeName = employeName;
		this.employeMail = employeMail;
		this.loginPassword = loginPassword;
		this.roleOfEmployee = roleOfEmployee;
	}

	public Employee(String employeName, String employeMail, String loginPassword, String roleOfEmployee) {
		this.employeName = employeName;
		this.employeMail = employeMail;
		this.loginPassword = loginPassword;
		this.roleOfEmployee = roleOfEmployee;
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


	public void setRoleOfEmployee(String roleOfEmployee) {
		this.roleOfEmployee = roleOfEmployee;
	}

}
