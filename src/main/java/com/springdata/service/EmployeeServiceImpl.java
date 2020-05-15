package com.springdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdata.dao.EmployeeDao;
import com.springdata.entity.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao empDao;
	
	@Override
	public void insertEmployee(Employee emp) {
		empDao.saveAndFlush(emp);
		System.out.println("Record inserted successfully");
	}

	@Override
	public void removeEmployee(int empId) {
		empDao.deleteById(empId);
		System.out.println("Record deleted successfully");
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = empDao.findAll();
		
		return allEmployees;
	}
	
}