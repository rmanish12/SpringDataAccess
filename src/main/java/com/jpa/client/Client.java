package com.jpa.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpa.entity.Employee;
import com.jpa.service.EmployeeService;

public class Client {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("jpa.config.xml");
		
		EmployeeService empService = context.getBean("employeeService", EmployeeService.class);
		
		Employee emp = new Employee(1003, "Jack", "Account");
		
//		empService.insert(emp);
		
//		empService.remove(1003);
		
		empService.update(1003, "Finance");
		
		List<Employee> allEmployees = empService.getAllEmployees();
		for(Employee e: allEmployees) {
			System.out.println(e);
		}
		
		context.close();
	}
	
}
