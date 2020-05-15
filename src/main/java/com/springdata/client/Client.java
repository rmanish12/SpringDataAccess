package com.springdata.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
        Employee emp3 = new Employee(1006, "Bob","HR");          
        Employee emp4 = new Employee(1007, "Aravind", "ENG"); 
        Employee emp5 = new Employee(1008, "Smitha", "ENG");  
		
//		employeeService.insertEmployee(emp1);
//		employeeService.insertEmployee(emp2);
//        employeeService.insertEmployee(emp3);
//        employeeService.insertEmployee(emp4);
//        employeeService.insertEmployee(emp5);
		
//		employeeService.removeEmployee(1004);
        
        Pageable pagable = PageRequest.of(2, 3);
        
        Iterable<Employee> employees = employeeService.paginatedEmployee(pagable);
        
        System.out.println("Paginated employees: ");
        for(Employee e: employees) {
        	System.out.println(e);
        }
        
        Sort sort = Sort.by(Sort.Direction.ASC, "empName");
        
        System.out.println("Sorted employees: ");
        List<Employee> sortedEmployees = employeeService.sortedEmployees(sort);
        for(Employee e: sortedEmployees) {
        	System.out.println(e);
        }
		
//		List<Employee> allEmployees = employeeService.getAllEmployees();
//		for(Employee e: allEmployees) {
//			System.out.println(e);
//		}
		
		context.close();
	}
	
}
