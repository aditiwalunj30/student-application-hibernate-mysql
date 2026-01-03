package com.abw.factory;

import com.abw.service.StudentService;
import com.abw.service.StudentServiceImpl;

public class StudentServiceFactory
{
	private static StudentService studentService;

	private StudentServiceFactory() {}

	public static StudentService getStudentServiceInstance()
	{
		if(studentService == null)
		{
			studentService = new StudentServiceImpl();
		}

		return studentService;
	}

}
