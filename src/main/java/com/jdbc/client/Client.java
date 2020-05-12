package com.jdbc.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.jdbc.bean.Employee;
import com.jdbc.config.SpringJdbcConfig;
import com.jdbc.service.EmployeeService;

public class Client {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		
		EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
		
		Employee emp = context.getBean("employee", Employee.class);
		emp.setEmpId(1);
		emp.setEmpName("Jack");
		emp.setDepartment("HR");
		
		employeeService.addEmployee(emp);
		
//		employeeService.removeEmployee(1);
		
		context.close();
	
	}

}
