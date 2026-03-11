package com.EmployeeManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.utility.HibernateUtility;

public class EmployeDao {

	// Added Singleton Pattern
	private static EmployeDao employeDao;
	private static final SessionFactory factory = HibernateUtility.getSessionFactory();
//	private static final String url = "jdbc:mysql://localhost:3306/employeeinfo";
//	private static final String user = "root";
//	private static final String password = "2106";
//
//	// Load Diver once
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException cnfEx) {
//			cnfEx.printStackTrace();
//		}
//
//	}

	private EmployeDao() {
	} // Made Constructor Private

	public static synchronized EmployeDao getInstance() {
		if (employeDao == null) {
			employeDao = new EmployeDao();
		}
		return employeDao;
	}

	public boolean insertEmployee(Employee employee) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(employee);

		transaction.commit();
		session.close();

		return true;

	}

	public Employee searchEmployee(Employee employee) {

		Session session = factory.openSession();

		String hql = "FROM Employee e WHERE e.employeMail = :mail AND e.loginPassword = :password";

		Query<Employee> query = session.createQuery(hql, Employee.class);

		query.setParameter("mail", employee.getEmployeMail());
		query.setParameter("password", employee.getLoginPassword());

		Employee emp = query.uniqueResult();

		session.close();

		return emp;

	}

	public ArrayList<Employee> selectAllEmployees() {

		Session session = factory.openSession();

		String hql = "FROM Employee";

		Query<Employee> query = session.createQuery(hql, Employee.class);

		List<Employee> list = query.list();

		ArrayList<Employee> employeeList = new ArrayList<>(list);

		return employeeList;
	}

	public boolean deletEmployee(int id, String mail) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "DELETE FROM Employee e WHERE e.employeId = :id AND e.employeMail = :mail";

		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("mail", mail);

		int result = query.executeUpdate();

		tx.commit();
		session.close();

		return result > 0;
	}

	public boolean updateEmployeePassword(Employee employee, String newPassword) {
		boolean isPasswordChanged = false;

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "UPDATE Employee SET loginPassword = :newPassword "
				+ "WHERE employeMail = :mail AND loginPassword = :oldPassword";

		Query query = session.createQuery(hql);

		query.setParameter("newPassword", newPassword);
		query.setParameter("mail", employee.getEmployeMail());
		query.setParameter("oldPassword", employee.getLoginPassword());

		int result = query.executeUpdate();

		tx.commit();
		session.close();

		return result > 0;
	}
}
