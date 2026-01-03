package com.abw.service;

import java.util.List;
import java.util.Scanner;

import com.abw.dao.CoursesDao;
import com.abw.dao.StudentDao;
import com.abw.entitites.Courses;
import com.abw.entitites.Student;
import com.abw.factory.CoursesDaoFactory;
import com.abw.factory.StudentDaoFactory;

public class CoursesServiceImpl implements CoursesService{

	@Override
	public Integer addCourses(Courses c) {
		
		CoursesDao coursesDao = CoursesDaoFactory.getCoursesDaoInstance();
		
		String cname = c.getCourseName().toLowerCase();
		c.setCourseName(cname);
		
		Integer courseid = coursesDao.saveCourse(c);
		
		return courseid;
		
	}

	@Override
	public Courses fetchCoursesById(Integer courseid) {
		
		CoursesDao coursesDao = CoursesDaoFactory.getCoursesDaoInstance();
		
		Courses c = coursesDao.findByCourseId(courseid);
		return c;
	}
	@Override
	public List<Courses> fetchCoursesByName(String coursename) {
		
		CoursesDao coursesDao = CoursesDaoFactory.getCoursesDaoInstance();
		List<Courses> coursesList = coursesDao.fetchCoursesByName(coursename.toLowerCase());
		return coursesList;
	}

	@Override
	public List<Courses> fetchAllCourses() {
		
		CoursesDao coursesDao = CoursesDaoFactory.getCoursesDaoInstance();
		List<Courses> coursesList = coursesDao.findAllCourses();
		
		return coursesList;
		
	}

	@Override
	public boolean modifyCourse(Integer courseid) {
		
		CoursesDao coursesDao = CoursesDaoFactory.getCoursesDaoInstance();
		
		Courses c = coursesDao.findByCourseId(courseid);
		if(c == null)
		{
			return false;
		}
		else
		{
			Scanner sc = new Scanner(System.in);
			String updatedName= "";
			
			while(true)
			{
				System.out.println("[Old Name :    " +  c.getCourseName()  + "  ] Enter New Name :   ");
				updatedName = sc.nextLine().toLowerCase();
				if(updatedName.isBlank())
					{
						System.out.println("*****Name should not be blank******");
						continue;
					}
				else
				{
					break;
				}
			}
			return coursesDao.updateCourse(c);
		}
		
	}

	@Override
	public boolean removeCourse(Integer courseid) {
		CoursesDao coursesdao = CoursesDaoFactory.getCoursesDaoInstance();
		
		Courses c = coursesdao.findByCourseId(courseid);
		if(c == null)
		{
			return false;
		}
		else
		{
			boolean status = coursesdao.removeCourse(c);
			return status;
		}
	}

}
