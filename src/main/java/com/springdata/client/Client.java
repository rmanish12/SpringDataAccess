package com.springdata.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdata.config.AppConfig;
import com.springdata.entity.Employee;
import com.springdata.service.EmployeeService;

public class Client {

	public static void main(String[] args) {
		
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.data.jpa.config.xml");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
		
		Employee emp1 = new Employee(1004, "Susan", "Engineering");
		Employee emp2 = new Employee(1005, "Allen", "Accounts");
		
//		employeeService.insertEmployee(emp1);
//		employeeService.insertEmployee(emp2);
		
		employeeService.removeEmployee(1004);
		
		List<Employee> allEmployees = employeeService.getAllEmployees();
		for(Employee e: allEmployees) {
			System.out.println(e);
		}
		
		context.close();
	}
	
}
