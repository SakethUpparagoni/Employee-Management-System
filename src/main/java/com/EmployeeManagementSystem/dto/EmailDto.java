package com.EmployeeManagementSystem.dto;

public class EmailDto {

	private String oldEmail;
	private String newEmail;
	private String password;

	public EmailDto() {
	}

	public EmailDto(String oldEmail, String newEmail, String password) {
		super();
		this.oldEmail = oldEmail;
		this.newEmail = newEmail;
		this.password = password;
	}

	public String getOldEmail() {
		return oldEmail;
	}

	public String getNewEmailnewEmail() {
		return newEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setOldEmail(String oldEmail) {
		this.oldEmail = oldEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
