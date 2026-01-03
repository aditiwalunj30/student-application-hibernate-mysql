 package com.abw.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.abw.dao.CoursesDao;
import com.abw.dao.RegistrationDao;
import com.abw.entitites.Courses;
import com.abw.entitites.Student;
import com.abw.factory.CoursesDaoFactory;
import com.abw.factory.RegistrationDaoFactory;
import com.abw.util.HibernateUtil;

public class RegistrationServiceImpl implements RegistrationService{

	@Override
	public boolean addRegistration(Integer id, Integer courseid) {
		
		RegistrationDao registrationDao = RegistrationDaoFactory.getRegistrationDaoInstance();
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            Student student = session.get(Student.class, id);
            Courses course = session.get(Courses.class, courseid);

            if (student != null && course != null) {
                return registrationDao.saveRegistration(student, course);
            }
            return false;
        }

	}
	@Override
	public List<Student> fetchStudents(Integer courseId) {
	    RegistrationDao registrationDao = RegistrationDaoFactory.getRegistrationDaoInstance();
	    SessionFactory sf = HibernateUtil.getSessionFactory();

	    try (Session session = sf.openSession()) {
	        Courses course = session.get(Courses.class, courseId);
	        if (course != null) {
	            return registrationDao.findStudents(course);
	        }
	        return List.of(); 
	    }
	}
	

	@Override
	public List<Courses> fetchCourses(Integer id) {
		
		RegistrationDao registrationDao = RegistrationDaoFactory.getRegistrationDaoInstance();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
        	Student student = session.get(Student.class, id);
            if (student != null) {
                return registrationDao.findCourses(student);
            }
            return null;
        }

		
	}

	@Override
	public boolean removeRegistration(Integer id, Integer courseid) {
		RegistrationDao registrationDao = RegistrationDaoFactory.getRegistrationDaoInstance();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            Student student = session.get(Student.class, id);
            Courses course = session.get(Courses.class, courseid);

            if (student != null && course != null) {
                return registrationDao.deleteRegistration(student, course);
            }
            return false;
        }
	}
	
	

}
