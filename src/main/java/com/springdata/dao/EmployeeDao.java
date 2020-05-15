package com.springdata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springdata.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	@Query("select e from Employee e where e.department=?1")
	List<Employee> findByDepartment(String department);
}
