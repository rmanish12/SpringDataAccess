package com.jdbc.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbc.bean.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	
	static Logger logger = Logger.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	@Autowired
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	public void addEmployee(Employee emp) {

		String query = "insert into employee values(?,?,?)";
		jdbcTemplate.update(query, emp.getEmpId(), emp.getEmpName(), emp.getDepartment());
		
		System.out.println("Record inserted successfully");
	}

	public int removeEmployee(int empId) {
		int id;
		
		id = jdbcTemplate.update("delete from employee where empId=?", empId);
		
		System.out.println("Record deleted successfully");
		return id;
	}
}
