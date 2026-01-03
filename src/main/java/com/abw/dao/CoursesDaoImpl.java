package com.abw.dao;

import java.util.List

;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.abw.entitites.Courses;
import com.abw.util.HibernateUtil;

public class CoursesDaoImpl implements CoursesDao{
	
	@Override
	public Integer saveCourse(Courses c)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction txn = null;
		
		try
		{
			session = sf.openSession();
			txn 	= session.beginTransaction();
			
			session.persist(c);
			Integer courseid =(Integer) session.getIdentifier(c);
			
			txn.commit();
			return courseid;
		}
		catch(Exception e)
		{
			if (txn != null)
			txn.rollback();
			return null;
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public Courses findByCourseId(Integer courseid) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Transaction txn = null;
		
		try(Session session = sf.openSession();){
			Courses c = session.get(Courses.class, courseid);
			return c;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Courses> fetchCoursesByName(String coursename) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		try
		{
			String hql = "FROM Courses where name LIKE '%\"+name+\"%'";
			Query<Courses> query = session.createQuery(hql,Courses.class);
			
			List<Courses> coursesList = query.getResultList();
			return coursesList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Courses> findAllCourses() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		try
		{
			String hql = "FROM COURSES";
			Query<Courses> query = session.createQuery(hql,Courses.class);
			
			List<Courses> coursesList = query.getResultList();
			return coursesList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateCourse(Courses c) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction txn = null;
		
		try
		{
			session = sf.openSession();
			txn = session.beginTransaction(); 
			
			session.merge(c);
			
			txn.commit();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			txn.rollback();
			return false;
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public boolean removeCourse(Courses c) {
		
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction txn = null;
		
		try
		{
			session = sf.openSession();
			txn = session.beginTransaction(); 
			
			session.remove(c);
			
			txn.commit();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			txn.rollback();
			return false;
		}
		finally
		{
			session.close();
		}
	}

}
