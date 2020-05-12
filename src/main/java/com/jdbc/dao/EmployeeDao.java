package com.jdbc.dao;

import com.jdbc.bean.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee emp);
	public int removeEmployee(int empId);
	
}
