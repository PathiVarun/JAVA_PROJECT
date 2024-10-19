package com.codegnan.UniversityManagement;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;// name of the student
	private List<Course> enrolledCourses;// List to hold courses the student enrolled in.

	public Student(String name) {
		this.name = name;
		this.enrolledCourses = new ArrayList();
	}

	// getter method to retrive the student's name.
	public String getName() {
		return name;
	}

	// method to enroll the student in a course

	public void enrollInCourse(Course course) {
		// check if the course is not already in the list of enrolled courses
		if (!enrolledCourses.contains(course)) {
			enrolledCourses.add(course);// add the course to a list
		}
	}

	// getter method to retrive the list of courses that student enrolled in.
	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}

//override toString() method to provide a String representation of the Student.
	public String toString() {
		return name;
	}
}
