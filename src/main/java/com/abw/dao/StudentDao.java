package com.abw.dao;

import java.util.List;

import com.abw.entitites.Student;


public interface StudentDao {

	abstract public Integer saveStudent(Student s);
	abstract public Student findStudentById(Integer id);
	abstract public List<Student> findStudentByName(String name);
	abstract public List<Student> findStudentByCity(String city);
	abstract public List<Student> findAllStudent();
	abstract public boolean updateStudent(Student s);
	abstract public boolean deleteStudent(Student s);
	}
