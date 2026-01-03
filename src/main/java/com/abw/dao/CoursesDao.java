package com.abw.dao;

import java.util.List;

import com.abw.entitites.Courses;

public interface CoursesDao {
	
	abstract public Integer saveCourse(Courses c); 
	abstract public Courses findByCourseId(Integer courseid);
	abstract public List<Courses> fetchCoursesByName(String coursename);
	abstract public List<Courses> findAllCourses();
	public abstract boolean updateCourse(Courses c); 
	public abstract boolean removeCourse(Courses c);

}
