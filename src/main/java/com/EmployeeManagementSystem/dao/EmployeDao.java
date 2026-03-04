package com.EmployeeManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.EmployeeManagementSystem.entity.Employee;

public class EmployeDao {

	// Added Singleton Pattern
	private static EmployeDao employeDao;
	private static final String url = "jdbc:mysql://localhost:3306/employeeinfo";
	private static final String user = "root";
	private static final String password = "2106";

	// Load Diver once
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}

	}

	private EmployeDao() {} // Made Constructor Private

	public static EmployeDao getInstance() {
		if (employeDao == null) {
			employeDao = new EmployeDao();
		}
		return employeDao;
	}

	public boolean insertEmployee(Employee employee) {

		String InsQueery = "INSERT INTO EMPLOYEEDATA(EMPNAME, EMPEMAIL, EMPPASSWORD, ROLE_OF_EMP) VALUES(?, ?, ?, ?)";

		try (Connection con = DriverManager.getConnection(url, user, password); // Try-with-Resource where Autocloseable
																				// objects call Close() automatically
				PreparedStatement ps = con.prepareStatement(InsQueery)) {

			ps.setString(1, employee.getEmployeName());
			ps.setString(2, employee.getEmployeMail());
			ps.setString(3, employee.getLoginPassword());
			ps.setString(4, employee.getRoleOfEmployee());

			return ps.executeUpdate() > 0; // Added Expression Based Return

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		return false;
	}

	public boolean searchEmployee(Employee employee) {

		String selQuery = "SELECT * FROM EMPLOYEEDATA WHERE EMPEMAIL = ? AND EMPPASSWORD = ?";

		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = con.prepareStatement(selQuery)) {

			ps.setString(1, employee.getEmployeMail());
			ps.setString(2, employee.getLoginPassword());

			try (ResultSet result = ps.executeQuery()) {
				if (result.next()) {

					employee.setEmployeName(result.getString(2));
					employee.setEmployeMail(result.getString(3));
					employee.setLoginPassword(result.getString(4));
					employee.setRoleOfEmployee(result.getString(5));
					return true;
				}
			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		return false;
	}

	public ArrayList<Employee> selectAllEmployees() {

		ArrayList<Employee> employeeList = new ArrayList<>();

		String selQuery = "SELECT * FROM EMPLOYEEDATA";

		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = con.prepareStatement(selQuery);
				ResultSet result = ps.executeQuery()) {

			while (result.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(result.getInt(1));
				employee.setEmployeName(result.getString(2));
				employee.setEmployeMail(result.getString(3));
				employee.setLoginPassword(result.getString(4));
				employee.setRoleOfEmployee(result.getString(5));

				employeeList.add(employee);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		return employeeList;
	}

	public boolean deletEmployee(int id, String mail) {
		String delQuery = "DELETE FROM EMPLOYEEDATA WHERE EMPID =? AND EMPEMAIL = ?";

		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = con.prepareStatement(delQuery)) {

			ps.setInt(1, id);
			ps.setString(2, mail);

			return ps.executeUpdate() > 0;
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		return false;
	}

	public boolean updateEmployeePassword(Employee employee) {
		String upQuery = "UPDATE EMPLOYEEDATA  SET EMPPASSWORD=? WHERE EMPEMAIL = ? AND EMPPASSWORD=?";

		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = con.prepareStatement(upQuery)) {

			ps.setString(1, employee.getNewpassword());
			ps.setString(2, employee.getEmployeMail());
			ps.setString(3, employee.getLoginPassword());

			return ps.executeUpdate() > 0;
		}

		catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		return false;
	}
}
