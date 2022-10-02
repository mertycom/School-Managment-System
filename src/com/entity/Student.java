package com.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Student extends Person implements Serializable{
	private static final long serialVersionUID = 2505840826556243074L;
	private String registrationNumber;
	private Faculty classRoom;
	private List<Lesson> lessons;
	private Phone phone;
	private static int idcounter=1;
	
	public Student(Name name, Gender gender, LocalDate birthDate, LocalDate startDate, LocalDate endDate,
			boolean married, Faculty classRoom, double mobilePhone,
				double homePhone,double parentPhone) throws StudentMarriedException{
		super(name, gender, birthDate, startDate, endDate, married);
		isMaried();
		this.lessons = new ArrayList<Lesson>();
		this.registrationNumber = Student.setId();
		this.classRoom = classRoom;
		this.phone = new Phone(mobilePhone, homePhone, parentPhone);
		idcounter++;
	}
	
	public void isMaried() throws StudentMarriedException {
		if(super.isMarried()) {
			throw new StudentMarriedException(this.getName() + " can't be married!!");
		}
	}
	
	public static String setId() {
		String number = String.format("%03d", Student.idcounter);
		return "STU" + number;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public Faculty getClassRoom() {
		return classRoom;
	}

	public Phone getPhone() {
		return phone;
	}

	@Override
	public String toString() {
		
		return registrationNumber + super.toString()+ ", classRoom=" + classRoom + ", lessons=" + lessons
				+ ", phone=" + phone +"]";
	}

	public void setLessons(List<Lesson> lesson) {
		this.lessons=lesson.stream().collect(Collectors.toList());
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void addLesson(Lesson lesson) {
		this.lessons.add(lesson);
	}



}
