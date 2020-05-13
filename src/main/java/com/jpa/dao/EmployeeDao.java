package com.jpa.dao;

import java.util.List;

import com.jpa.entity.Employee;

public interface EmployeeDao {

	public void insert(Employee emp);
	public void remove(int empId);
	public List<Employee> getAllEmployees();
	public void update(int empId, String department);
	
}
