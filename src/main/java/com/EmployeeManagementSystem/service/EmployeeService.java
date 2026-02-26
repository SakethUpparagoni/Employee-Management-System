package com.EmployeeManagementSystem.service;

import java.util.ArrayList; 

import com.EmployeeManagementSystem.dao.EmployeDao;
import com.EmployeeManagementSystem.entity.Employee;

public class EmployeeService {
	EmployeDao employeDao = new EmployeDao();

	public boolean signUpEmployee(Employee employee) {

		return employeDao.insertEmployee(employee);
	}

	public boolean loginEmployee(Employee employee) {
		return employeDao.searchEmployee(employee);
	}

	public ArrayList<Employee> getAllEmployees() {
		return employeDao.selectAllEmployees();
	}

	public boolean removeEmployee(int id, String mail) {
		return employeDao.deletEmployee(id, mail);
	}

	public boolean changeEmployeePassword(Employee employee) {
		return employeDao.updateEmployeePassword(employee);
	}

}
