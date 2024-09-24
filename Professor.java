package com.codegnan.UniversityManagement;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	private String name;
	private List<Course> assignedCourses;// List to hold Courses assigned to the professor

	public Professor(String name) {
		this.name = name;// set the Professor name.
		this.assignedCourses = new ArrayList();// Initialize the List of Assigned Courses as an Empty List
	}

	// getter method to retrive the professor name
	public String getName() {
		return name;
	}

	// method to assign a course to the professor
	public void assignCourse(Course course) {

		// To check if the course is not already in the list of assignedCourses.
		if (!assignedCourses.contains(course)) {
			assignedCourses.add(course);// assigned the course to the list if not already present.
		}
	}

	// getter method to retrive the list of courses assigned to the professor.
	public List<Course> getassignedCourses() {
		return assignedCourses;// return the list of assigned courses.
	}

	// override toString() method to provide String representation of the professor.

	public String toString() {
		return name;// return the professor names as the String representation.
	}
}
