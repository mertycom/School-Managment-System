package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.entity.Employe;
import com.entity.Faculty;
import com.entity.Gender;
import com.entity.Jobs;
import com.entity.Lesson;
import com.entity.Name;
import com.entity.Student;
import com.entity.StudentMarriedException;
import com.school.School;

public class BAUutil extends Statics implements Serializable {
	private static final long serialVersionUID = 1L;;
	public static Set<Student> studentList = new HashSet<>();
	public static Set<Lesson> lessonList = new HashSet<>();
	public static Set<Employe> employeList = new HashSet<>();
	private static School school;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menuLoop();
	}

	private static void menuLoop() {
		newEmployes();
		newStudents();

		while (true) {
			showMenuItems();
			int option = sc.nextInt();
			selectMenu(option);
		}

	}

	private static void writeObjectToFile(Object serObj, File file) {
		try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(file))) {
			objectOut.writeObject(serObj);
			objectOut.close();
			System.out.println("The Object was succesfully written to a file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static Object readEmployeFromFile() {

		try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(EMPLOYEE_COUNTER_PATH))) {
			Object obj = (Employe) objectIn.readObject();

			System.out.println("The Object has been read from the file");
			objectIn.close();
			return obj;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public static void showMenuItems() {
		System.out.println("\n#########################################################");
		System.out.println(Messages.getString("BAUutil.SCHOOL_MANAGMENT_SYSTEM")); 
		System.out.println("#########################################################");

		System.out.println(Messages.getString("BAUutil.ADD_EMPLOYEE"));
		System.out.println(Messages.getString("BAUutil.EMPLOYEE_LIST"));
		System.out.println(Messages.getString("BAUutil.EX_EMPLOYEES"));
		System.out.println(Messages.getString("BAUutil.NEW_CLASS"));
		System.out.println(Messages.getString("BAUutil.STUDENT_ASSIGNMENT"));
		System.out.println(Messages.getString("BAUutil.CLASS_LIST"));
		System.out.println(Messages.getString("BAUutil.CLASSES_ATTENDEND_STUDENT"));
		System.out.println(Messages.getString("BAUutil.GIFT_LIST"));
		System.out.println(Messages.getString("BAUutil.SALARY_LIST"));
		System.out.println(Messages.getString("BAUutil.EXIT"));
		System.out.println("#########################################################");
	}

	public static void selectMenu(int choice) {
		switch (choice) {
		case 1:
			newEmployes();
			System.out.println(Messages.getString("BAUutil.EMPLOYES_ADDED"));
			break;
		case 2:
			listEmployees();
			break;
		case 3:
			listOldEmployees();
			break;
		case 4:
			newLessons();
			break;
		case 5:
			assignStudentsToLesson();
			break;
		case 6:
			lessonsList(school.getLessons());
			break;
		case 7:
			studentLessons();
			break;
		case 8:
			giftList();
			break;
		case 9:
			calculateSalary();
			break;
		case 10:
			endLoop();
			break;
		default:
			System.out.println(Messages.getString("BAUutil.WRONG_INPUT")); 
		}
	}

	private static void lessonsList(List<Lesson> lessons) {
		for (Lesson lesson : lessons) {
			System.out.println(lesson.getName());
			lesson.getStudents().stream().forEach(i -> System.out.println(i));
		}
	}

	private static void studentLessons() {
		System.out.println(Messages.getString("BAUutil.ENTER_STUDENT_REG_NUMBER"));
		sc.nextLine();
		String studentId = sc.nextLine();

		studentList.stream().filter(i -> i.getRegistrationNumber().equalsIgnoreCase(studentId))
				.collect(Collectors.toList()).get(0);

	}

	private static void newLessons() {
		List<Employe> teacherList = employeList.stream().filter(i -> i.getJob() == Jobs.TEACHER)
				.collect(Collectors.toList());

		Lesson lesson1 = new Lesson(teacherList.get(1), teacherList.get(0), "Java Programming", "2020", "3 Saat", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"Perşembe, 14:00-17:00"); //$NON-NLS-1$
		Lesson lesson2 = new Lesson(teacherList.get(0), teacherList.get(1), "C# Programming", "2019", "3 Saat", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"Cuma, 14:00-17:00"); //$NON-NLS-1$

		lessonList.add(lesson1);
		lessonList.add(lesson2);
		/* <<<<<<< Her seferinde veri girişlerinden kurtulmak için bir
		text dosyasına yazıp geri okunabilir >>>>>>>>>>>>*/
		school.addLesson(lesson1);
		school.addLesson(lesson2);
		//writeObjectToFile(school, SCHOOL_OBJECT_PATH);

	}

	private static void assignStudentsToLesson() {

		List<Student> engineeringStudents = studentList.stream()
				.filter(i -> i.getClassRoom().equals(Faculty.ENGINEERING)).toList();

		// <<<<<<<<< Her seferinde veri girişlerinden kurtulmak için >>>>>>>>>//
		for (Student stu : engineeringStudents) {
			school.addStudent(stu);
			school.getLessons().get(0).addStudent(stu);
			school.getLessons().get(1).addStudent(stu);
		}

	}

	private static void newStudents() {

		try {
			Student stu = new Student(new Name("Sayit", null, "Keklikcioglu"), Gender.MALE, LocalDate.of(1989, 7, 8), //$NON-NLS-1$ //$NON-NLS-2$
					LocalDate.of(2018, 1, 1), null, false, Faculty.ENGINEERING, 555d, 543d, 222d);
			Student stu2 = new Student(new Name("Sait", "Faik", "Abasiyanik"), Gender.MALE, LocalDate.of(1989, 7, 8), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					LocalDate.of(2008, 10, 1), LocalDate.of(2010, 1, 1), false, Faculty.ENGINEERING, 555d, 543d, 222d);
			Student stu3 = new Student(new Name("Kemal", null, "Kemalettin"), Gender.MALE, LocalDate.of(1989, 7, 8), //$NON-NLS-1$ //$NON-NLS-2$
					LocalDate.of(2018, 1, 1), LocalDate.of(2022, 1, 1), false, Faculty.HEALTH_SCIENCES, 555d, 543d,
					222d);
			Student stu4 = new Student(new Name("Gamze", null, "Cetiner"), Gender.FEMALE, LocalDate.of(2006, 10, 8), //$NON-NLS-1$ //$NON-NLS-2$
					LocalDate.of(2020, 10, 1), null, false, Faculty.ENGINEERING, 555d, 543d, 222d);
			Student stu5 = new Student(new Name("Ayse", "Evli", "Imis"), Gender.FEMALE, LocalDate.of(2006, 10, 8), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					LocalDate.of(2020, 10, 1), null, true, Faculty.HEALTH_SCIENCES, 555d, 543d, 222d);
			studentList.add(stu);
			studentList.add(stu2);
			studentList.add(stu3);
			studentList.add(stu4);
			studentList.add(stu5);

		} catch (NullPointerException e) {
			System.out.println(e.toString());
		} catch (StudentMarriedException e) {
			System.out.println(e.toString());
		}

		writeObjectToFile(studentList, STUDENT_COUNTER_PATH);
	}

	private static void giftList() {
		System.out.println(Messages.getString("BAUutil.EMP_STARTING_DATES_THISMONTH")); //$NON-NLS-1$
		int thisMonth = LocalDate.now().getMonthValue();

		employeList.stream().filter(i -> i.getStartDate().getMonthValue() == thisMonth)
				.forEach(s -> System.out.println("# " + s.getId() + s.getName())); //$NON-NLS-1$

		System.out.println(Messages.getString("BAUutil.EMP_WOMAN_BIRTHDAY_THISMONTH")); //$NON-NLS-1$

		List<Employe> femaleEmploye = employeList.stream().filter(i -> i.getGender() == Gender.FEMALE)
				.collect(Collectors.toList());

		femaleEmploye.stream().filter(i -> i.getBirthDate().getMonthValue() == thisMonth)
				.forEach(s -> System.out.println("# " + s.getId() + s.getName())); //$NON-NLS-1$

	}

	private static void calculateSalary() {
		List<Employe> listEmploye = employeList.stream().filter(i -> i.getEndDate() == null).toList();

		for (Employe employe : listEmploye) {
			System.out.println(employe.getId() + "" + employe.getName() + " : " + employe.calculateCurrentSalary()); //$NON-NLS-1$ //$NON-NLS-2$
		}

	}

	private static void listOldEmployees() {
		employeList.stream().filter(i -> i.getEndDate() != null).forEach(i -> System.out.println(i));
	}

	private static void listEmployees() {
		employeList.stream().filter(i -> i.getEndDate() == null).forEach(i -> System.out.println(i));
	}

	private static void newEmployes() {
		Employe emp = new Employe(new Name("Baris", "Mert", "Comertoglu"), Gender.MALE, LocalDate.of(1990, 1, 31), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				LocalDate.of(2016, 2, 1), null, true, 3500d, Jobs.OFFICER, 5435003414d, 5435003414d);
		employeList.add(emp);
		emp = new Employe(new Name("Kamil", null, "Papuccu"), Gender.MALE, LocalDate.of(1998, 10, 5), //$NON-NLS-1$ //$NON-NLS-2$
				LocalDate.of(2022, 1, 1), null, true, 5000d, Jobs.TEACHER, 503414d, 5434d);
		employeList.add(emp);

		emp = new Employe(new Name("Kadriye", null, "Akkasik"), Gender.FEMALE, LocalDate.of(2002, 9, 5), //$NON-NLS-1$ //$NON-NLS-2$
				LocalDate.of(2022, 10, 1), null, true, 15000d, Jobs.TEACHER, 503414d, 5434d);
		employeList.add(emp);
		emp = new Employe(new Name("Halime", null, "Guven"), Gender.FEMALE, LocalDate.of(2003, 10, 5), //$NON-NLS-1$ //$NON-NLS-2$
				LocalDate.of(2020, 3, 1), LocalDate.of(2022, 3, 1), true, 15000d, Jobs.SERVANT, 503414d, 5434d);
		employeList.add(emp);

		writeObjectToFile(employeList, EMPLOYEE_COUNTER_PATH);

	}

	public static void endLoop() {
		System.out.println(Messages.getString("BAUutil.LOG_OUT")); //$NON-NLS-1$
		if (sc.next().equalsIgnoreCase(Messages.getString("BAUutil.TYPE_YES"))) { //$NON-NLS-1$
			System.out.println(Messages.getString("BAUutil.BYE")); //$NON-NLS-1$
			sc.close();
			System.exit(0);
		}
	}
}
