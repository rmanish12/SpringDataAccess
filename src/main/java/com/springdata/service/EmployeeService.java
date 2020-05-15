package com.springdata.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.springdata.entity.Employee;

public interface EmployeeService {

	public void insertEmployee(Employee emp);
	public void removeEmployee(int empId);
	public List<Employee> getAllEmployees();
	public List<Employee> sortedEmployees(Sort sort);
	public Page<Employee> paginatedEmployee(Pageable page);
	public List<Employee> findByDepartment(String department);
	
}
