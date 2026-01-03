package com.abw.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.abw.entitites.Courses;
import com.abw.entitites.Registration;
import com.abw.entitites.Student;
import com.abw.util.HibernateUtil;

public class RegistrationDaoImpl implements RegistrationDao {

	@Override
	public boolean saveRegistration(Student student, Courses course) {
	    SessionFactory sf = HibernateUtil.getSessionFactory();
	    Transaction txn = null;

	    try (Session session = sf.openSession()) {
	        txn = session.beginTransaction();

	        // Fetch managed entities
	        Student managedStudent = session.get(Student.class, student.getRno());
	        Courses managedCourse = session.get(Courses.class, course.getCourseId());

	        // Validate existence
	        if (managedStudent == null || managedCourse == null) {
	            System.out.println("Student or Course not found in DB!");
	            return false;
	        }

	        // Create and persist registration
	        Registration reg = new Registration();
	        reg.setStudent(managedStudent);
	        reg.setCourse(managedCourse);
	        reg.setRegDate(LocalDate.now());

	        session.persist(reg);

	        txn.commit();
	        return true;
	    } catch (Exception e) {
	        if (txn != null) txn.rollback();
	        e.printStackTrace();
	        return false;
	    }
	}
	@Override
	public List<Student> findStudents(Courses c) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Transaction txn = null;
		
		try(Session session = sf.openSession())
		{
			String hql = "SELECT r.student FROM Registration r WHERE r.course = :course";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("course", c);
            return query.getResultList();

			
		}
	}

	@Override
	public List<Courses> findCourses(Student s) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT r.course FROM Registration r WHERE r.student = :student";
            Query<Courses> query = session.createQuery(hql, Courses.class);
            query.setParameter("student", s);
            return query.getResultList();
        }

	}

	@Override
	public boolean deleteRegistration(Student s, Courses c) {
		Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();

            String hql = "DELETE FROM Registration r WHERE r.student = :student AND r.course = :course";
            Query<?> query = session.createQuery(hql);
            query.setParameter("student", s);
            query.setParameter("course", c);

            int rows = query.executeUpdate();
            txn.commit();

            return rows > 0;
        } catch (Exception e) {
            if (txn != null) txn.rollback();
            e.printStackTrace();
            return false;
        }
    }

	}


