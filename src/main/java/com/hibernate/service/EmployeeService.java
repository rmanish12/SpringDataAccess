package com.hibernate.service;

import java.util.List;

import com.hibernate.entity.Employee;

public interface EmployeeService {

	public void insert(Employee emp);
	public int delete(int empId);
	public List<Employee> getEmployees();
	
}
