package com.abw.service;

import java.util.List;
import java.util.Scanner;

import com.abw.dao.StudentDao;
import com.abw.entitites.Student;
import com.abw.factory.StudentDaoFactory;

public  class StudentServiceImpl implements StudentService {

	@Override
	public Integer addStudent(Student s)
	{

		StudentDao studentDao = StudentDaoFactory.getStudentDaoInstance();

		String tname = s.getName().toLowerCase();
		String tcity  = s.getCity().toLowerCase();

		s.setName(tname);
		s.setCity(tcity);


		Integer id = studentDao.saveStudent(s);

		return id;
	}


	@Override
	public Student findStudentById(Integer id) {


		StudentDao studentDao = StudentDaoFactory.getStudentDaoInstance();

		Student s = studentDao.findStudentById(id);
		return s;
	}


	@Override
	public List<Student> fetchStudentByName(String name) {
		
		
		StudentDao studentdao = StudentDaoFactory.getStudentDaoInstance();
		List<Student> studentList = studentdao.findStudentByName(name.toLowerCase());
		return studentList;
		
		/*
	 	
	 	return StudentDaoFactory.getStudentDaoInstance().findStudentByName(name.toLowerCase())
	 
	 */
	}


	@Override
	public List<Student> fetchStudentByCity(String city) {
		
		StudentDao studentdao = StudentDaoFactory.getStudentDaoInstance();
		List<Student> studentList = studentdao.findStudentByCity(city.toLowerCase());
		return studentList;
		
	}
	
	@Override
	public List<Student> fetchAllStudent() {
		
		StudentDao studentdao = StudentDaoFactory.getStudentDaoInstance();
		List<Student> studentList = studentdao.findAllStudent();
		return studentList;
		
	}


	@Override
	public boolean modifyStudent(Integer id) {
		
		StudentDao studentdao = StudentDaoFactory.getStudentDaoInstance();
		
		Student s = studentdao.findStudentById(id);
		if(s == null)
		{
			return false;
		}
		else {
			Scanner sc = new Scanner(System.in);
			String updatedName= "";
			
			while(true)
			{
				System.out.println("[Old Name :    " +  s.getName()  + "  ] Enter New Name :   ");
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
			
			System.out.println("[Old City :    " +  s.getCity()  + "  ] Enter New City :   ");
			String updatedCity = sc.nextLine().toLowerCase();
			
			System.out.println("[Old Percentage :    " +  s.getPer()  + " ] Enter New Percentage :   ");
			Double updatedPercentage = sc.nextDouble();
			
			s.setName(updatedName);
			s.setCity(updatedCity);
			s.setPer(updatedPercentage);
			
			return studentdao.updateStudent(s);

		}
		
		
	}


	@Override
	public boolean removeStudent(Integer id) {
		
		StudentDao studentdao = StudentDaoFactory.getStudentDaoInstance();
		
		Student s = studentdao.findStudentById(id);
		if(s == null)
		{
			return false;
		}
		else
		{
			boolean status = studentdao.deleteStudent(s);
			return status;
		}
	}


	
}
