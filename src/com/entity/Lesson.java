package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Lesson implements Serializable{
	private static final long serialVersionUID = 3759716861543969964L;
	
	private Employe masterTrainer;
	private Employe asistantTrainer;
	private String name;
	private String year;
	private List<Student> students;
	private String lessonTime;
	private String lessonDateBetween;
	
	public Lesson() {
		this.students = new ArrayList<Student>();
	}
	
	public Lesson(Employe masterTrainer, Employe asistantTrainer, String name, String year,
			String lessonTime, String lessonDateBetween) {
		super();
		this.masterTrainer = masterTrainer;
		this.asistantTrainer = asistantTrainer;
		this.name = name;
		this.year = year;
		this.students = new ArrayList<Student>();
		this.lessonTime = lessonTime;
		this.lessonDateBetween = lessonDateBetween;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Employe getMasterTrainer() {
		return masterTrainer;
	}

	public Employe getAsistantTrainer() {
		return asistantTrainer;
	}

	public String getName() {
		return name;
	}

	public String getYear() {
		return year;
	}

	public List<Student> getStudents() {
		return students;
	}

	public String getLessonTime() {
		return lessonTime;
	}

	public String getLessonDateBetween() {
		return lessonDateBetween;
	}

	@Override
	public String toString() {
		return name+ "[masterTrainer=" + masterTrainer + ", asistantTrainer=" + asistantTrainer
				+ ", year=" + year + ", students=" + students + ", lessonTime=" + lessonTime + ", lessonDateBetween="
				+ lessonDateBetween + "]";
	}


	public void setStudents(List<Student> students) {
		this.students=students.stream().collect(Collectors.toList());
	}

	public void addStudent(Student student) {
		students.add(student);
	}


	

}
