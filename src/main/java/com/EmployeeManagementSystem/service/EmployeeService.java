package com.EmployeeManagementSystem.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.dao.EmployeDao;
import com.EmployeeManagementSystem.dto.EmailDto;
import com.EmployeeManagementSystem.dto.PasswordDto;
import com.EmployeeManagementSystem.entity.Employee;

@Service
public class EmployeeService {

// Added Singleton Pattern The Singleton Pattern is a Creational Design Pattern that ensures:
// Only one object of a class is created
//  Provides a global access point to that obj

	private EmployeDao employeDao;

//	private static EmployeeService employeeService;

	@Autowired
	private EmployeeService(EmployeDao employeDao) {
		this.employeDao = employeDao;
	}
//
//	public static EmployeeService getInstance() {
//		if (employeeService == null) {
//			employeeService = new EmployeeService();
//		}
//		return employeeService;
//	}

	public boolean signUpEmployee(Employee employee) {

		Employee existing = employeDao.getEmployeeByEmail(employee);

		if (existing != null) {
			return false;
		}

		return employeDao.insertEmployee(employee);
	}

	public Employee loginEmployee(Employee employee) {
		return employeDao.searchEmployee(employee);
	}

	public ArrayList<Employee> getAllEmployees() {
		return employeDao.selectAllEmployees();
	}

	public boolean removeEmployee(int id, String mail) {
		return employeDao.deletEmployee(id, mail);
	}

	public boolean updatePassword(PasswordDto dto) {
		return employeDao.updateEmployeePassword(dto);
	}

	public boolean updateEmail(EmailDto dto) {
		return employeDao.updateEmployeeEmail(dto);
	}
	public Employee getEmployeeById(int id) {
		return employeDao.getEmployeeEId(id);
	}
	public void deleteEmployeeById(int id) {
		employeDao.deleteEmployeeById(id);
	}
	
	public void updateEmployee(Employee emp) {
		 employeDao.updateEmployee(emp);
	}

}
