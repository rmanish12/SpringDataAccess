package com.transaction.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.transaction.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void update(Student st) {
		Student student = entityManager.find(Student.class, st.getId());
		student.setBaseLocation(st.getBaseLocation());
		student.setAddress(st.getAddress());
		entityManager.merge(student);
	}

	@Override
	public void insert(Student st) {
		entityManager.persist(st);
		
		System.out.println("Record inserted");
	}

	@Override
	public Student getStudent(int id) {
		Student student = entityManager.find(Student.class, id);
		
		if(student==null) {
			return null;
		}
		
		return student;
	}
	
}
