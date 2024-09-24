package com.codegnan.UniversityManagement;

public class Course {
	private String title; // title of the course.

	public Course(String title) {
		this.title = title;
	}

	// getter method to retrive the course title.
	public String getTitle() {
		return title;// return the course title.
	}

//Override toString method to provide a String representation of the Course.
	public String toString() {
		return title;// return the course title as per the String representation
	}
}
