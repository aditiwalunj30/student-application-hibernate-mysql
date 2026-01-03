package com.abw.service;

import java.util.List;

import com.abw.entitites.Courses;
import com.abw.entitites.Student;

public interface RegistrationService {
	
	abstract public boolean addRegistration(Integer id, Integer courseid);
	abstract public List<Student> fetchStudents(Integer id);
	abstract public List<Courses> fetchCourses(Integer courseid);
	abstract public boolean removeRegistration(Integer id, Integer courseid);

}
