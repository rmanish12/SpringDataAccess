package com.transaction.service;

import org.springframework.transaction.annotation.Transactional;

import com.transaction.entity.Student;

@Transactional
public interface StudentService {

	public void update(Student st);
	public void insert(Student st);
	public Student getStudent(int id);
	
}
