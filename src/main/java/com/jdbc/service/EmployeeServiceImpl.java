package com.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbc.bean.Employee;
import com.jdbc.dao.EmployeeDao;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		employeeDao.addEmployee(emp);
	}

	@Override
	public int removeEmployee(int empId) {
		// TODO Auto-generated method stub
		return employeeDao.removeEmployee(empId);
	}

}
