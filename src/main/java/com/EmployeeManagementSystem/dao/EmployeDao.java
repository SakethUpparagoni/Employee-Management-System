package com.EmployeeManagementSystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.EmployeeManagementSystem.dto.EmailDto;
import com.EmployeeManagementSystem.dto.PasswordDto;
import com.EmployeeManagementSystem.entity.Employee;

@Repository
public class EmployeDao {

//	private static EmployeDao employeDao;
	@Autowired
	private SessionFactory factory;
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

//	private EmployeDao() {
//	} // Made Constructor Private
//
//	public static synchronized EmployeDao getInstance() {
//		if (employeDao == null) {
//			employeDao = new EmployeDao();
//		}
//		return employeDao;
//	}
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

	public Employee getEmployeeByEmail(Employee employee) {

		Session session = factory.openSession();

		String hql = "FROM Employee e WHERE e.employeMail = :mail";

		Query<Employee> query = session.createQuery(hql, Employee.class);

		query.setParameter("mail", employee.getEmployeMail());

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

	public boolean updateEmployeePassword(PasswordDto dto) {

		Session session = factory.openSession();
		Transaction tx = null;
		boolean isUpdated = false;

		try {
			tx = session.beginTransaction();

			String hql = "UPDATE Employee e SET e.loginPassword = :newPassword "
					+ " WHERE e.employeMail = :mail AND e.loginPassword = :oldPassword";

			Query<?> query = session.createQuery(hql);

			query.setParameter("newPassword", dto.getNewPassword());
			query.setParameter("mail", dto.getEmployeeMail());
			query.setParameter("oldPassword", dto.getOldPassword());

			int result = query.executeUpdate();

			tx.commit();
			isUpdated = result > 0;

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return isUpdated;
	}

	public boolean updateEmployeeEmail(EmailDto dto) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "UPDATE Employee SET employeMail = :newEmail "
				+ " WHERE employeMail = :mail AND loginPassword = :password";

		Query query = session.createQuery(hql);

		query.setParameter("newEmail", dto.getNewEmailnewEmail());
		query.setParameter("mail", dto.getOldEmail());
		query.setParameter("password", dto.getPassword());

		int result = query.executeUpdate();

		tx.commit();
		session.close();

		return result > 0;
	}

	public void deleteEmployeeById(int id) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Employee emp = (Employee) session.get(Employee.class, id);

		if (emp != null) {
			session.delete(emp);
		}
		tx.commit();
		session.close();

	}

	public Employee getEmployeeEId(int id) {

		Session session = factory.openSession();
		Employee emp = null;
		try {
			 emp = (Employee) session.get(Employee.class, id);

		} finally {
			session.close();
		}
		return emp;

	}
	
	 public void updateEmployee(Employee emp) {

		 Session session = factory.openSession();
		    Transaction tx = session.beginTransaction();

		    session.update(emp);

		    tx.commit();
		    session.close();
	}
}
