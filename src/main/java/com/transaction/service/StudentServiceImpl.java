package com.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.dao.StudentDao;
import com.transaction.entity.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;

	@Override
	@Transactional(timeout = 40)
	public void update(Student st) {
		studentDao.update(st);
	}

	@Override
	public void insert(Student st) {
		studentDao.insert(st);
	}

	@Override
	@Transactional(readOnly = true)
	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}
	
}