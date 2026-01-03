# Student Registration System (Hibernate + MySQL)

A console-based Java application that manages students, courses, and registrations using Hibernate ORM and MySQL.  
It demonstrates entity relationships, foreign key constraints, and CRUD operations with proper JPA annotations.

## ✨ Features
- Add, update, delete students and courses
- Register students for courses
- Fetch students by course and courses by student
- Hibernate/JPA annotations for entity mapping
- MySQL integration with foreign key constraints

## 🛠 Tech Stack
- Java (Core + OOP)
- Hibernate ORM
- MySQL
- Eclipse IDE

## 🗄️ Database Schema
- `STUDENTS` (RNO, Name, City, Percentage, DateCreated, DateUpdated)
- `COURSES` (CourseId, CourseName, Duration, DateCreated, DateUpdated)
- `REGISTRATIONS` (Rid, RNO → STUDENTS, CourseId → COURSES, RegDate, DateCreated, DateUpdated)

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/aditiwalunj30/student-application-hibernate-mysql.git
