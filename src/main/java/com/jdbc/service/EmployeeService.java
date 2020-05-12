package com.jdbc.service;

import com.jdbc.bean.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee emp);
	public int removeEmployee(int empId);
	
}
