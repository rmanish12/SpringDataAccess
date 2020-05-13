package com.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	Session session = null;
	Transaction txn = null;
	
	@Override
	public void insert(Employee emp) {
		session = sessionFactory.openSession();
		txn = session.beginTransaction();
		
		session.save(emp);
		txn.commit();
		
		System.out.println("Record inserted successfully");
		session.close();
	}

	@Override
	public int delete(int empId) {
		int result = 0;
		
		session = sessionFactory.openSession();
		txn = session.beginTransaction();
		
		try {
			Employee emp = session.get(Employee.class, empId);
			
			session.delete(emp);
			result = 1;
			txn.commit();
			
			System.out.println("Record deleted successfully");
			
		} catch(Exception e) {
			txn.rollback();
		} finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> allEmployees = null;
		
		session = sessionFactory.openSession();
		txn = session.beginTransaction();
		
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
			
			criteria.from(Employee.class);
			
			allEmployees = session.createQuery(criteria).getResultList();
			
			System.out.println("Retrieving all employees");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.clear();
		}
		
		return allEmployees;
	}

	@Override
	public void update(int empId, String department) {
		
		session = sessionFactory.openSession();
		txn = session.beginTransaction();
		
		try {
			Employee emp = session.get(Employee.class, empId);
			
			emp.setDepartment(department);
			session.update(emp);
			
			txn.commit();
			System.out.println("Record updated successfully");
		} catch(Exception e) {
			txn.rollback();
		} finally {
			session.close();
		}
		
	}

}
