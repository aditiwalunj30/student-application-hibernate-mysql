package com.abw.factory;

import com.abw.dao.CoursesDao;
import com.abw.dao.CoursesDaoImpl;
import com.abw.dao.RegistrationDao;
import com.abw.dao.RegistrationDaoImpl;

public class RegistrationDaoFactory {
	
private static RegistrationDao registrationDao;
	
	private RegistrationDaoFactory () {}
	
	public static RegistrationDao getRegistrationDaoInstance()
	{
		if(registrationDao==null)
		{
			registrationDao = new RegistrationDaoImpl();
		}
		return registrationDao;

	}

}
