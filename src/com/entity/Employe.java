package com.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Employe extends Person implements Serializable, Workable {

	private static final long serialVersionUID = 1L;
	private String id;
	private double startingSalary;
	private double salary;
	private static int idCountForTeacher = 1;
	private static int idCountForOfficer = 1;
	private static int idCountForServant = 1;
	private Jobs job;
	private Phone phone;

	public Employe(Name name, Gender gender, LocalDate birthDate, LocalDate startDate, LocalDate endDate,
			boolean married, double startingSalary, Jobs job, double mobilePhone, double homePhone) {
		super(name, gender, birthDate, startDate, endDate, married);
		this.startingSalary = startingSalary;
		this.salary = calculateCurrentSalary();
		this.job = job;
		this.id = assignEmployeeNumber();
		this.phone = new Phone(mobilePhone, homePhone);
	}

	public String getId() {
		return id;
	}

	public double getStartingSalary() {
		return startingSalary;
	}

	public double getSalary() {
		return salary;
	}

	public Jobs getJob() {
		return job;
	}

	@Override
	public double assignSalaryIncreaseRate() {
		if (this.job == Jobs.TEACHER)
			return 10.0;
		else if (this.job == Jobs.OFFICER)
			return 9.0;
		else
			return 8.5;
	}

	@Override
	public double calculateCurrentSalary() {
		long years = super.getStartDate().until(LocalDate.now(), ChronoUnit.YEARS);
		double currentSalary = this.startingSalary;

		for (int i = 0; i < years * 2; i++) {
			currentSalary = currentSalary * (100.0 + this.assignSalaryIncreaseRate()) / 100;
		}

		return currentSalary;
	}

	@Override
	public String assignEmployeeNumber() {
		String number;
		if (this.job == Jobs.TEACHER) {
			number = stringFormatter(idCountForTeacher);
			idCountForTeacher++;
			return "T" + number;
		} else if (this.job == Jobs.OFFICER) {
			number = stringFormatter(idCountForOfficer);
			idCountForOfficer++;
			return "O" + number;
		}
		number = stringFormatter(idCountForServant);
		idCountForServant++;
		return "S" + number;
	}

	private String stringFormatter(int idcounter) {
		String number = String.format("%03d", idcounter);
		return number;
	}

	public Phone getPhone() {
		return phone;
	}

}
