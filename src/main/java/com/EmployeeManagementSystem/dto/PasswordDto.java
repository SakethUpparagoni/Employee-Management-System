package com.EmployeeManagementSystem.dto;

public class PasswordDto {

	private String oldPassword;
	private String newPassword;
	private String employeeMail;

	public PasswordDto() {
	}

	public PasswordDto(String oldPassword, String newPassword, String employeeMail) {
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.employeeMail = employeeMail;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public String getEmployeeMail() {
		return employeeMail;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}

}
