package com.school;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.entity.Employe;
import com.entity.Lesson;
import com.entity.Student;

public class School implements Serializable {
	private static final long serialVersionUID = -576373386878327387L;

	private List<Employe> employees;
	private List<Student> students;
	private List<Lesson> lessons;

	public School() {
		this.employees = new ArrayList<Employe>();
		this.students = new ArrayList<Student>();
		this.lessons = new ArrayList<Lesson>();
	}

	public Student getStudent(String registrationNumber) {
		return this.students.stream().filter(i -> i.getRegistrationNumber().equalsIgnoreCase(registrationNumber))
				.collect(Collectors.toList()).get(0);
	}

	public void addEmployee(Employe employee) {
		this.employees.add(employee);
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void addLesson(Lesson lesson) {
		this.lessons.add(lesson);
	}

	public List<Employe> getEmployees() {
		return employees;
	}

	public List<Student> getStudents() {
		return students;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	@Override
	public String toString() {
		return "[employee=" + employees + ", students=" + students + ", lessons=" + lessons + "]";
	}
}
