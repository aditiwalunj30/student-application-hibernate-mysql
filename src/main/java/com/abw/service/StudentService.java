package com.abw.service;

import java.util.List;

import com.abw.entitites.Student;

public interface StudentService {


	public abstract Integer addStudent(Student s);
	public abstract Student findStudentById(Integer id);
	public abstract List<Student> fetchStudentByName(String name);
	public abstract List<Student> fetchStudentByCity(String city);
	public abstract List<Student> fetchAllStudent();
	public abstract boolean modifyStudent(Integer id); 
	public abstract boolean removeStudent(Integer id);

}
