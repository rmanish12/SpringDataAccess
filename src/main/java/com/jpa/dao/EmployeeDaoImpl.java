package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	EntityManager entityManager = null;
	
	@Override
	public void insert(Employee emp) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(emp);
			entityManager.getTransaction().commit();
			
			System.out.println("Record inserted");
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public void remove(int empId) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			Employee emp = entityManager.find(Employee.class, empId);
			entityManager.remove(emp);
			entityManager.getTransaction().commit();
			
			System.out.println("Record deleted");
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = null;
		
		entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("Select e from Employee e");
		
		allEmployees = query.getResultList();
		
		System.out.println("Retrieved all employees");
		return allEmployees;
	}

	@Override
	public void update(int empId, String department) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			Employee emp = entityManager.find(Employee.class, empId);
			emp.setDepartment(department);
			entityManager.getTransaction().commit();
			
			System.out.println("Record updated");
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
	}

}
