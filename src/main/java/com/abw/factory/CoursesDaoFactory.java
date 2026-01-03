package com.abw.factory;

import com.abw.dao.CoursesDao;
import com.abw.dao.CoursesDaoImpl;

public class CoursesDaoFactory {
	
	private static CoursesDao coursesDao;
	
	private CoursesDaoFactory () {}
	
	public static CoursesDao getCoursesDaoInstance()
	{
		if(coursesDao==null)
		{
			coursesDao = new  CoursesDaoImpl();
		}
		return coursesDao;

	}
}
