package com.codegnan.UniversityManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityManagement {

	private List<Student> students;// list to hold students
	private List<Professor> professors;// list to hold professors
	private List<Course> courses;// list to hold courses

	// Constructor initializes empty list for students,professors,courses.
	public UniversityManagement() {
		students = new ArrayList<>();
		professors = new ArrayList<>();
		courses = new ArrayList<>();
	}

	// method to add a student

	public void addStudent(String name) {
		students.add(new Student(name));
	}

	// method to add a professor

	public void addProfessor(String name) {
		professors.add(new Professor(name));
	}

	// method to add a Course

	public void addCourse(String title) {
		courses.add(new Course(title));
	}

	// method to enroll a student in a course

	public void enrollStudentInCourse(String studentName, String courseTitle) {
		Student student = findStudentByName(studentName);// find the student by name
		Course course = findCourseByTitle(courseTitle);// find the course by title
		if (student != null && course != null) {
			student.enrollInCourse(course);// enroll the student in the course
		} else {
			System.out.println("Student or Course Not Found ");// error message if not found
		}
	}

	// method to assign a course to a professor

	public void assignCourseToProfessor(String professorName, String courseTitle) {
		Professor professor = findProfessorByName(professorName);// find the professor by name
		Course course = findCourseByTitle(courseTitle);// find the course by title
		if (professor != null && course != null) {
			professor.assignCourse(course);// assign the course to the professor
		} else {
			System.out.println("Professor or Course Not Found ");// error message if not found
		}
	}

	// method to list all students

	public void listStudents() {
		System.out.println("List of Students in University : ");
		for (Student student : students) {
			System.out.println(student);// print each students name
		}
	}

	// method to list all professors

	public void listProfessors() {
		System.out.println("List of Professors in University : ");
		for (Professor professor : professors) {
			System.out.println(professor);// print each Professors name
		}
	}

	// method to list of all courses

	public void listCourses() {
		System.out.println("List of courses in University : ");
		for (Course course : courses) {
			System.out.println(course);// print each Courses name
		}
	}

	// method to display the courses a student is enrolledin
	public void displayStudentCourses(String studentName) {
		Student student = findStudentByName(studentName);// find the student by name
		if (student != null) {
			System.out.println("Courses for Student : " + studentName + " : ");
			for (Course course : student.getEnrolledCourses()) {
				System.out.println(course);// print each enrolledCourse.
			}
		} else {
			System.out.println("Student Not Found : ");// error message if not found.
		}
	}

	// method to display the course assigned to professor

	public void displayProfessorCourses(String professorName) {
		Professor professor = findProfessorByName(professorName);// find the professor by name
		if (professor != null) {
			System.out.println("Courses assigned to professor " + professorName + " : ");
			for (Course course : professor.getassignedCourses()) {
				System.out.println(course);// print each enrolledCourse.
			}
		} else {
			System.out.println("Professor Not Found : ");// error message if professor not found.
		}
	}

	// Helper method to find a student by name

	private Student findStudentByName(String name) {
		for (Student student : students) {
			if (student.getName().equals(name)) {
				return student;// return the student if found
			}
		}
		return null;// return the null if student not found
	}

	// Helper method to find a professor by name

	private Professor findProfessorByName(String name) {
		for (Professor professor : professors) {
			if (professor.getName().equals(name)) {
				return professor;// return professor if found
			}
		}
		return null;// return null if professor not found
	}

	// Helper method to find a course by title

	private Course findCourseByTitle(String title) {
		for (Course course : courses) {
			if (course.getTitle().equals(title)) {
				return course;// return course if found
			}
		}
		return null;// return null if course not found
	}

	public static void main(String[] args) {

		UniversityManagement management = new UniversityManagement();
		Scanner sc = new Scanner(System.in);
		boolean running = true;// flag to control while loop

		while (running) {
			System.out.println("\n University Management System ");
			System.out.println("1. Add Student ");
			System.out.println("2. Add Professor ");
			System.out.println("3. Add Course ");
			System.out.println("4. Enroll Student in Course ");
			System.out.println("5. Assign Course to Professor ");
			System.out.println("6. List of Students in University ");
			System.out.println("7. List of Professors in University ");
			System.out.println("8. List of Courses ");
			System.out.println("9. Display Student Courses ");
			System.out.println("10. Display Professor Courses ");
			System.out.println("11. Exit ");

			System.out.print(" Choose an Option : ");
			int choice = sc.nextInt();
			sc.nextLine();// Consume the new line character
			switch (choice) {
			case 1:
				System.out.print("Enter Student Name : ");
				String studentName = sc.nextLine();
				management.addStudent(studentName);// add the student
				break;
			case 2:
				System.out.print("Enter Professor : ");
				String professorName = sc.nextLine();
				management.addProfessor(professorName);// add the professor
				break;
			case 3:
				System.out.print("Enter Course Title : ");
				String courseTitle = sc.nextLine();
				management.addCourse(courseTitle);// add the course
				break;
			case 4:
				System.out.print("Enter Student name : ");
				String enrollStudent = sc.nextLine();
				System.out.print("Enter Course Title ");
				String enrollCourse = sc.nextLine();
				management.enrollStudentInCourse(enrollStudent, enrollCourse);// enroll student in course
				break;
			case 5:
				System.out.print("Enter Professor Name : ");
				String assignProfessor = sc.nextLine();
				System.out.print("Enter Course Title ");
				String assignCourse = sc.nextLine();
				management.assignCourseToProfessor(assignProfessor, assignCourse);// assign course to professor
				break;
			case 6:
				management.listStudents();// list of all Students
				break;
			case 7:
				management.listProfessors();// list of all Professors
				break;
			case 8:
				management.listCourses();// list all courses
				break;
			case 9:
				System.out.print("Enter Student Name : ");
				String displayStudent = sc.nextLine();
				management.displayStudentCourses(displayStudent);// display Courses for Student
				break;
			case 10:
				System.out.print("Enter Professor Name : ");
				String displayProfessor = sc.nextLine();
				management.displayProfessorCourses(displayProfessor);// display Courses for Professor
				break;
			case 11:
				running = false;// exit the loop
				System.out.println("Existing....");
				break;
			default:
				System.out.println("Invalid Choice. Please enter a number between 1 to 11 ");// handle invalid inputs
				break;

			}
		}
		sc.close();

	}

}
