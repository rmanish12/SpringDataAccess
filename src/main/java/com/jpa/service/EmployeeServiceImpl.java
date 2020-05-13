package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.dao.EmployeeDao;
import com.jpa.entity.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void insert(Employee emp) {
		employeeDao.insert(emp);
	}

	@Override
	public void remove(int empId) {
		employeeDao.remove(empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public void update(int empId, String department) {
		employeeDao.update(empId, department);	
	}

}
