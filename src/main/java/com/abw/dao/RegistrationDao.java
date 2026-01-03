package com.abw.dao;

import java.util.List;

import com.abw.entitites.Courses;
import com.abw.entitites.Student;

public interface RegistrationDao {
	
	abstract public boolean saveRegistration(Student student,Courses course);
	abstract public List<Student> findStudents(Courses c);
	abstract public List<Courses> findCourses(Student s);
	abstract public boolean deleteRegistration(Student s, Courses c);
}
