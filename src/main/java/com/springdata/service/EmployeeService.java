package com.springdata.service;

import java.util.List;

import com.springdata.entity.Employee;

public interface EmployeeService {

	public void insertEmployee(Employee emp);
	public void removeEmployee(int empId);
	public List<Employee> getAllEmployees();
	
}
