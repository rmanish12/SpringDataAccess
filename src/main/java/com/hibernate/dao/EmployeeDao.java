package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.Employee;

public interface EmployeeDao {

	public void insert(Employee emp);
	public int delete(int empId);
	public List<Employee> getEmployees();
	
}
