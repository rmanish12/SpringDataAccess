package com.springdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdata.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
