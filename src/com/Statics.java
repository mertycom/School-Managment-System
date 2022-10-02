package com;

import java.io.File;
import java.time.format.DateTimeFormatter;

public class Statics {
	public final static String MAIN_WORKING_DIRECTORY ="C:\\Users\\snozd\\eclipse-workspace\\OYSS\\src\\com\\resources"; 
	public final static File EMPLOYEE_COUNTER_PATH = new File(MAIN_WORKING_DIRECTORY, "Employee.dat"); 
	public final static File STUDENT_COUNTER_PATH = new File(MAIN_WORKING_DIRECTORY, "Student.dat"); 
	public final static File SCHOOL_OBJECT_PATH = new File(MAIN_WORKING_DIRECTORY, "School.dat"); 
	public final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); 
	

}