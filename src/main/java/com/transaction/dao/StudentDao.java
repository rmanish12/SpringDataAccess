package com.transaction.dao;

import com.transaction.entity.Student;

public interface StudentDao {
	
	public void update(Student st);
	public void insert(Student st);
	public Student getStudent(int id);
	
}
