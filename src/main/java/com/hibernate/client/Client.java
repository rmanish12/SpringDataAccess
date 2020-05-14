package com.hibernate.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.config.SpringHibernateConfig;
import com.hibernate.entity.Employee;
import com.hibernate.service.EmployeeService;

public class Client {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("hibernate.cfg.xml");
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringHibernateConfig.class);
		
		EmployeeService empService = context.getBean("employeeService", EmployeeService.class);
		
//		Employee emp1 = new Employee(1000, "Alex", "Account");
		Employee emp2 = new Employee(1001, "Sam", "HR");
		
//		empService.insert(emp1);
		empService.insert(emp2);
		
//		empService.delete(1001);
		
//		empService.update(1000, "Engineering");
		
		List<Employee> allEmployees = empService.getEmployees();
		for(Employee e: allEmployees) {
			System.out.println(e);
		}
		
		context.close();
	}

}
