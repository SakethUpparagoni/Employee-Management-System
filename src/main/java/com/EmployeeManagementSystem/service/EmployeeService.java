package com.EmployeeManagementSystem.service;

import java.util.ArrayList;

import com.EmployeeManagementSystem.dao.EmployeDao;
import com.EmployeeManagementSystem.entity.Employee;

public class EmployeeService {

// Added Singleton Pattern The Singleton Pattern is a Creational Design Pattern that ensures:
// Only one object of a class is created
//  Provides a global access point to that obj
	
	EmployeDao employeDao = EmployeDao.getInstance();

	private static EmployeeService employeeService;

	private EmployeeService() {}

	public static EmployeeService getInstance() {
		if (employeeService == null) {
			employeeService = new EmployeeService();
		}
		return employeeService;
	}

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
