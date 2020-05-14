package com.transaction.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.transaction.entity.Address;
import com.transaction.entity.Student;
import com.transaction.service.StudentService;

public class Client {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("transaction.config.xml");
		
		StudentService stService = context.getBean("studentService", StudentService.class);
		
		Address addr = new Address(1001, "MCity,Chennai", "610004");
		Student st = new Student(101, "Smith", "IVS", "Chennai", addr);
		
//		stService.insert(st);
		
		Address address = new Address(1001, "Ecity,Bangalore", "610023");
		st.setBaseLocation("Bangalore");
		st.setAddress(address);
		
//		try {
//			stService.update(st);
//			System.out.println("Update successful");
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//		}
		
		Student st1 = stService.getStudent(101);
		
		if(st1==null) {
			System.out.println("No record found");
		} else {
			System.out.println(st1);
		}
		
		context.close();
	}
}
