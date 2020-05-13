package com.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.dao.EmployeeDao;
import com.hibernate.entity.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void insert(Employee emp) {
		employeeDao.insert(emp);
	}

	@Override
	public int delete(int empId) {
		return employeeDao.delete(empId);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	public void update(int empId, String department) {
		employeeDao.update(empId, department);
	}
	
}
