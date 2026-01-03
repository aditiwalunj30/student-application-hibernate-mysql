package com.abw.service;

import java.util.List;

import com.abw.entitites.Courses;

public interface CoursesService {
	
	abstract public Integer addCourses(Courses c);
	abstract public Courses fetchCoursesById(Integer courseid);
	abstract public List<Courses> fetchCoursesByName(String coursename);
	abstract public List<Courses> fetchAllCourses();
	public abstract boolean modifyCourse(Integer courseid); 
	public abstract boolean removeCourse(Integer courseid);


}
