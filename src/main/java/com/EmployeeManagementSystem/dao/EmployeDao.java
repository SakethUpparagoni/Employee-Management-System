package com.EmployeeManagementSystem.dao;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.EmployeeManagementSystem.entity.Employee;

public class EmployeDao {

	public boolean insertEmployee(Employee employee) {
		boolean isInsertEmp = false;

		Connection con = null;
		PreparedStatement ps = null;
		String url = "jdbc:mysql://localhost:3306/employeeinfo";
		String user = "root";
		String password = "2106";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String InsQueery = "INSERT INTO EMPLOYEEDATA(EMPNAME, EMPEMAIL, EMPPASSWORD, ROLE_OF_EMP) VALUES(?, ?, ?, ?)";
			ps = con.prepareStatement(InsQueery);

			ps.setString(1, employee.getEmployeName());
			ps.setString(2, employee.getEmployeMail());
			ps.setString(3, employee.getLoginPassword());
			ps.setString(4, employee.getRoleOfEmployee());

			int insertion = ps.executeUpdate();

			if (insertion != 0) {
				isInsertEmp = true;
			}
		}

		catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		return isInsertEmp;
	}

	public boolean searchEmployee(Employee employee) {
		boolean isFoundEmp = false;

		Connection con = null;
		PreparedStatement ps = null;
		String url = "jdbc:mysql://localhost:3306/employeeinfo";
		String user = "root";
		String password = "2106";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String InsQueery = "SELECT * FROM EMPLOYEEDATA WHERE EMPEMAIL = ? AND EMPPASSWORD = ?";
			ps = con.prepareStatement(InsQueery);

			ps.setString(1, employee.getEmployeMail());
			ps.setString(2, employee.getLoginPassword());

			ResultSet result = ps.executeQuery();

			if (result.next()) {
				isFoundEmp = true;

				employee.setEmployeName(result.getString(2));
				employee.setEmployeMail(result.getString(3));
				employee.setLoginPassword(result.getString(4));
				employee.setRoleOfEmployee(result.getString(5));
			}
		}

		catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		return isFoundEmp;
	}

	public ArrayList<Employee> selectAllEmployees() {

		ArrayList<Employee> employeeList = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		String url = "jdbc:mysql://localhost:3306/employeeinfo";
		String user = "root";
		String password = "2106";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String selQuery = "SELECT * FROM EMPLOYEEDATA";

			ps = con.prepareStatement(selQuery);

			ResultSet result = ps.executeQuery();

			while (result.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(result.getInt(1));
				employee.setEmployeName(result.getString(2));
				employee.setEmployeMail(result.getString(3));
				employee.setLoginPassword(result.getString(4));
				employee.setRoleOfEmployee(result.getString(5));

				employeeList.add(employee);
			}
		}

		catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		return employeeList;
	}

	public boolean deletEmployee(int id, String mail) {
		boolean isDeleted = false;

		Connection con = null;
		PreparedStatement ps = null;
		String url = "jdbc:mysql://localhost:3306/employeeinfo";
		String user = "root";
		String password = "2106";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String delQuery = "DELETE FROM EMPLOYEEDATA WHERE EMPID =? AND EMPEMAIL = ?";
			ps = con.prepareStatement(delQuery);

			ps.setInt(1, id);
			ps.setString(2, mail);

			int rowsEffected = ps.executeUpdate();

			if (rowsEffected != 0) {
				isDeleted = true;
			}
		}

		catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		return isDeleted;
	}

	public boolean updateEmployeePassword(Employee employee) {
		boolean isUpdatedPassword = false;

		Connection con = null;
		PreparedStatement ps = null;
		String url = "jdbc:mysql://localhost:3306/employeeinfo";
		String user = "root";
		String password = "2106";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			String upQuery = "UPDATE EMPLOYEEDATA  SET EMPPASSWORD=? WHERE EMPEMAIL = ? AND EMPPASSWORD=?";

			ps = con.prepareStatement(upQuery);

			ps.setString(1, employee.getNewpassword());
			ps.setString(2, employee.getEmployeMail());
			ps.setString(3, employee.getLoginPassword());

			int rowsEffected = ps.executeUpdate();

			if (rowsEffected != 0) {
				isUpdatedPassword = true;

			} else {
				isUpdatedPassword = false;
			}
		}

		catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		return isUpdatedPassword;
	}
}
