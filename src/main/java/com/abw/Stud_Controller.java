package com.abw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.abw.entitites.Courses;
import com.abw.entitites.Student;
import com.abw.factory.CoursesServiceFactory;
import com.abw.factory.RegistrationServiceFactory;
import com.abw.factory.StudentServiceFactory;
import com.abw.service.CoursesService;
import com.abw.service.RegistrationService;
import com.abw.service.StudentService;
import com.abw.util.HibernateUtil;

public class Stud_Controller {

	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		System.out.println("\n**********Welcome to Omkar Maths Academy***********");
		
		try
		{
			while(true) {
				System.out.println("Menu");
				
				System.out.println("1. Save ");
				System.out.println("2. Fetch By Id");
				System.out.println("3. Fetch By Name");
				System.out.println("4. Fetch By City");
				System.out.println("5. FetchAll");
				System.out.println("6. Update");
				System.out.println("7. Delete");
				System.out.println("8. Save Course ");
				System.out.println("9.Fetch Coures By id");
				System.out.println("10.Fetch Coures By name");
				System.out.println("11.Fetch All Coures ");
				System.out.println("12.Update Coures");
				System.out.println("13.Delete Courses");
				System.out.println("14.Save Registration");
				System.out.println("15.Fetch Registration By Studentid");
				System.out.println("16.Fetch Registrations By Courseid");
				System.out.println("17.Delete Registration");
				System.out.println("18. Exit");
				
			
			System.out.print("What is your Choice :  ");
			int choice = Integer.parseInt(br.readLine());
				switch(choice)
				{
					case 1: optionSaveStudent();
							break;
							
					case 2: optionFetchStudentById();
							break;
					
					case 3: optionFetchStudentByName();
							break;
							
					case 4: optionFetchStudentByCity();
							break;
							
					case 5: optionFetchAllStudent();
							break;
							
					case 6: optionUpdateStudent();
							break;
							
					case 7: optionDeleteStudent();
							break;
							
					case 8: optionSaveCourses();
							break;
							
							
					case 9:optionFetchCourseById();
							break;
							
					case 10:optionFetchByCourseName();
							break;
					
					case 11:optionFetchAllCourses();
							break;
							
					case 12:optionUpdateCourse();
							break;
					
					case 13:optionDeleteCourse();
							break;
							
					case 14:optionSaveRegistration();
							break;
							
					case 15:optionFetchRegistrationByStudentId();
							break;
							
					case 16:optionFetchRegistrationsByCourseId();
							break;
					
					case 17:optionDeleteRegistration();
							break;
							
					case 18: HibernateUtil.closeSessionFactory();
							System.out.println("********** Shutdown System ************* !!!");
							System.exit(0);
							
					default:
							System.out.println("***** Invalid choice ! *****");

							
				}
			
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.closeSessionFactory();
			System.out.println("DONE!!!!!!");
		}
		
}

	

	private static void optionSaveStudent() {

		Scanner sc = new Scanner(System.in);
		StudentService service = StudentServiceFactory.getStudentServiceInstance();

		try
		{
		System.out.print("Enter the Name :  " );
		String name = sc.nextLine();

		System.out.print("Enter the percentage :  ");
		Double per = sc.nextDouble();

		System.out.print("Enter the city :  ");
		String city = sc.next();

		Student s  = new Student();
		s.setName(name);
		s.setPer(per);
		s.setCity(city);

		Integer id =service.addStudent(s);

		//StudentDao   	dao    = StudentDaoFactory.getStudentDao();

		if(id == null)
		{
			System.out.println("Unable to save record");
		}
		else
		{
			System.out.println("Record is saved successfully");
			System.out.println("Registered ID : " + id);
		}
	}
	catch(Exception e) {
			System.out.println("Problem During Registering User!!");
		}


	}

	private static void optionFetchStudentById()
	{
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);


		try
		{
			System.out.print("Enter your roll no to find your data :  ");
			int rno= sc.nextInt();

			Student s = service.findStudentById(rno);
			if(s==null)
			{
				System.out.println("Record not found for roll number :  " + rno);
			}
			else {
				System.out.println("******Record Successfully found ******");
				System.out.println("--------------------------------------");
				System.out.println("Roll Number :  " + s.getRno());
				System.out.println("Name :    " +  s.getName());
				System.out.println("Percentage :       " + s.getPer() );
				System.out.println("City :     " + s.getCity());
				System.out.println();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void optionFetchStudentByName()
	{
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter Student Name to get Data : ");
			String name = sc.nextLine();
			
			List<Student> L = service.fetchStudentByName(name);
			
			if(L==null || L.isEmpty()) 
			{
				System.out.println("No Records Found for Name : " + name);
			}
			else
			{
				System.out.println("** Record Found ** ");
				System.out.println("----------------------------");
				
				for(Student s : L)
				{
					System.out.println("Roll Number : " + s.getRno());
					System.out.println("Name        : " + s.getName());
					System.out.println("Percentage  : " + s.getPer());
					System.out.println("City        : " +  s.getCity());
					System.out.println("");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
	
	private static void optionFetchStudentByCity()
	{
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter City Name to get Data : ");
			String city = sc.nextLine();
			
			List<Student> L = service.fetchStudentByCity(city);
			
			if(L==null || L.isEmpty()) 
			{
				System.out.println("No Records Found for City : " + city);
			}
			else
			{
				System.out.println("** Record Found ** ");
				System.out.println("----------------------------");
				
				for(Student s : L)
				{
					System.out.println("Roll Number : " + s.getRno());
					System.out.println("Name        : " + s.getName());
					System.out.println("Percentage  : " + s.getPer());
					System.out.println("City        : " +  s.getCity());
					System.out.println("");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void optionFetchAllStudent()
	{
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			
			List<Student> L = service.fetchAllStudent();
			
			if(L==null || L.isEmpty()) 
			{
				System.out.println("No Records Found !! ");
			}
			else
			{
				System.out.println("** Record Found ** ");
				System.out.println("----------------------------");
				
				for(Student s : L)
				{
					System.out.println("Roll Number : " + s.getRno());
					System.out.println("Name        : " + s.getName());
					System.out.println("Percentage  : " + s.getPer());
					System.out.println("City        : " +  s.getCity());
					System.out.println("");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void optionUpdateStudent() {
		
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter Student Id : ");
			int rno = sc.nextInt();
			
			boolean status = service.modifyStudent(rno);
			if(status)
			{
				System.out.println("Record is updated successfully for Roll Number :  " + rno);
			}
			else
			{
				System.out.println("Failed to update for Roll Number :  " + rno);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Problem during update Student");
			e.printStackTrace();
		}
		
	}
	
private static void optionDeleteStudent() {
		
		StudentService service = StudentServiceFactory.getStudentServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter Student Id : ");
			int rno = sc.nextInt();
			
			boolean status = service.removeStudent(rno);
			if(status)
			{
				System.out.println("Record is deleted successfully for Roll Number :  " + rno);
			}
			else
			{
				System.out.println("Failed to delete for Roll Number :  " + rno);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Problem during delete Student");
			e.printStackTrace();
		}
		
	}

	private static void optionSaveCourses()
	{
		Scanner sc = new Scanner(System.in);
		CoursesService service = CoursesServiceFactory.getCoursesServiceInstance();
		
		try
		{
		System.out.print("Enter the Name :  " );
		String coursename = sc.nextLine();

		Courses c = new Courses();
		c.setCourseName(coursename);  
		
		Integer courseid =service.addCourses(c);

		if(courseid == null)
		{
			System.out.println("Unable to save course");
		}
		else
		{
			System.out.println("Record is saved successfully");
			System.out.println("Registered ID : " + courseid);
		}
	}
	catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problem During Registering course!!");
		}


	}
	
	
	private static void optionFetchCourseById()
	{
		CoursesService service = CoursesServiceFactory.getCoursesServiceInstance();
		Scanner sc = new Scanner(System.in);


		try
		{
			System.out.print("Enter your course id to find your data :  ");
			int courseid = sc.nextInt();

			Courses c = service.fetchCoursesById(courseid);
			if(c==null)
			{
				System.out.println("Record not found for courseid :  " + courseid);
			}
			else {
				System.out.println("******Record Successfully found ******");
				System.out.println("--------------------------------------");
				System.out.println("Course Id  :  " + c.getCourseId());
				System.out.println("Name :    " +  c.getCourseName());
				System.out.println();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	private static void optionFetchByCourseName() {
		
		CoursesService service = CoursesServiceFactory.getCoursesServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter Course Name :  ");
			String name = sc.nextLine();
			
			List<Courses> L = service.fetchCoursesByName(name);
			
			if(L==null || L.isEmpty())
			{
				System.out.println("No Records found for CourseName: " + name);
			}
			else
			{
				System.out.println("** Record Found **");
				System.out.println("----------------------------");
				
				for (Courses c :L)
				{
					System.out.println("CourseId : " + c.getCourseId());
					System.out.print("Name :  " + c.getCourseName());
					System.out.println("");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private static void optionFetchAllCourses()
	{
		CoursesService service = CoursesServiceFactory.getCoursesServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			
			List<Courses> L = service.fetchAllCourses();
			
			if(L==null || L.isEmpty()) 
			{
				System.out.println("No Records Found !! ");
			}
			else
			{
				System.out.println("** Record Found ** ");
				System.out.println("----------------------------");
				
				for(Courses c : L)
				{
					System.out.println("Course Name:   " + c.getCourseName());
					System.out.println("");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private static void optionUpdateCourse()
	{
		CoursesService service = CoursesServiceFactory.getCoursesServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter Course id: ");
			int courseid = sc.nextInt();
			
			boolean status = service.modifyCourse(courseid);
			if(status)
			{
				System.out.println("Record updated successfully for course id:  " + courseid);
			}
			else
			{
				System.out.println("Failed to update course fo courseid : " + courseid);
			}
		}
		catch(Exception e) {
			System.out.println("Problem during updating Course");
			e.printStackTrace();
		}
	}
	
	private static void optionDeleteCourse()
	{
		CoursesService service = CoursesServiceFactory.getCoursesServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.println("Enter course id:  ");
			int courseid = sc.nextInt();
			
			boolean status = service.removeCourse(courseid);
			if(status)
			{
				System.out.println("Record delete1d successfully for course id : " + courseid);
			}
			else
			{
				System.out.println("Failed during deleting course");
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Problem during deleting course");
			e.printStackTrace();
		}
	}
	
	private static void optionSaveRegistration()
	{
		RegistrationService service = RegistrationServiceFactory.getRegistrationServiceInstance();
		Scanner sc = new Scanner(System.in);
			
		try
			{
			System.out.print("Enter the Student id :  "  );
			Integer id = sc.nextInt();
			
			System.out.print("Enter the Course id:  ");
			Integer courseid = sc.nextInt();
			
			boolean success = service.addRegistration(id, courseid);
			if(success)
			{
				System.out.println("Registration Saved succesfully");
			}
			else
			{
				System.out.println("Unable to save Registration");
			}
			  
		}
		catch(Exception e) {
				e.printStackTrace();
				System.out.println("Problem During Saving Registration!!");
			}

	}
	
	private static void optionFetchRegistrationByStudentId()
	{
		RegistrationService service = RegistrationServiceFactory.getRegistrationServiceInstance();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.println("Enter the id to fetch : ");
			Integer id = sc.nextInt();
			
			List<Student> L = service.fetchStudents(id);
			
			if(L==null || L.isEmpty())
			{
				System.out.println("No Records found for Registration: " + id);
			}
			else
			{
				System.out.println("** Record Found **");
				System.out.println("----------------------------");
				
				for (Student s :L)
				{
					System.out.println("StudentId : " + s.getRno());
					System.out.println("");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Problem During Finding Registration By Student id!!");
		}
		
	}
	
	private static void optionFetchRegistrationsByCourseId() {
	    CoursesService service = CoursesServiceFactory.getCoursesServiceInstance();
	    Scanner sc = new Scanner(System.in);

	    try {
	        System.out.print("Enter the course id to fetch: ");
	        Integer courseid = sc.nextInt();

	        Courses c = service.fetchCoursesById(courseid);

	        if (c == null) {
	            System.out.println("Record not found for course id: " + courseid);
	        } else {
	            System.out.println("****** Record Successfully found ******");
	            System.out.println("--------------------------------------");
	            System.out.println("Course ID: " + c.getCourseId());
	            System.out.println("Course Name: " + c.getCourseName());
	            
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Problem during finding Course by ID");
	    }
	}
	
	private static void optionDeleteRegistration() {
	    RegistrationService service = RegistrationServiceFactory.getRegistrationServiceInstance();
	    Scanner sc = new Scanner(System.in);

	    try {
	        System.out.print("Enter student id: ");
	        int id = sc.nextInt();

	        System.out.print("Enter course id: ");
	        int courseid = sc.nextInt();

	        boolean status = service.removeRegistration(id, courseid);

	        if (status) {
	            System.out.println("Registration deleted successfully for student id: " 
	                               + id + " and course id: " + courseid);
	        } else {
	            System.out.println("Failed during deleting registration");
	        }
	    } catch (Exception e) {
	        System.out.println("Problem during deleting registration");
	        e.printStackTrace();
	    }
	}
	
}

