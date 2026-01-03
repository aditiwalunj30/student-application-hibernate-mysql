package com.abw.factory;

import com.abw.dao.StudentDao;
import com.abw.dao.StudentDaoImpl;

public class StudentDaoFactory
{

	private static  StudentDao studentDao;

	private StudentDaoFactory() {}

	public static StudentDao getStudentDaoInstance()
	{
		if(studentDao == null)
		{
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
}
