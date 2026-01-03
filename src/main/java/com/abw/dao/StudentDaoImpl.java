package com.abw.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.abw.entitites.Student;
import com.abw.util.HibernateUtil;



public class StudentDaoImpl implements StudentDao {

	@Override
	public Integer saveStudent(Student s) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session  session = null;
		Transaction txn =null;

		try
		{
			session = sf.openSession();
			txn = session.beginTransaction();

			session.persist(s);
			Integer id =(Integer) session.getIdentifier(s);

			txn.commit();
			return id;
		}
		catch(Exception e)
		{
			txn.rollback();
			return null;
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public Student findStudentById(Integer id) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Transaction txn = null;

		try(Session session = sf.openSession();) {
			Student s = session.get(Student.class,id);
			return s;

		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Student> findStudentByName(String name) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		try
		{
			String hql = "FROM Student where name LIKE '%"+name+"%'";
			Query<Student> query = session.createQuery(hql, Student.class);

			List<Student> studentsList = query.getResultList();
			return studentsList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Student> findStudentByCity(String city) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		try
		{
			String hql = "FROM Student where city LIKE '%"+city+"%'";
			Query<Student> query = session.createQuery(hql, Student.class);

			List<Student> studentsList = query.getResultList();
			return studentsList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Student> findAllStudent() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		try
		{
			String hql = "FROM Student";
			Query<Student> query = session.createQuery(hql, Student.class);

			List<Student> studentsList = query.getResultList();
			return studentsList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean updateStudent(Student s) {
		

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction txn = null;
		
		try
		{
			session = sf.openSession();
			txn = session.beginTransaction(); 
			
			session.merge(s);
			
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
	public boolean deleteStudent(Student s) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction txn = null;
		
		try
		{
			session = sf.openSession();
			txn = session.beginTransaction(); 
			
			session.remove(s);
			
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
