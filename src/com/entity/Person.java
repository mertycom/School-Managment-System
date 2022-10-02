package com.entity;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Person implements Serializable {
	private static final long serialVersionUID = -3667080273536540541L;
	
	private Name name;
	private Gender gender;
	private LocalDate birthDate;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean married;
	
	public Person(Name name, Gender gender, LocalDate birthDate, LocalDate startDate, LocalDate endDate,
			boolean married) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.married = married;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}

	@Override
	public String toString() {
		return name + ", gender=" + gender + ", birthDate=" + birthDate + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", married=" + married + "]";
	}
	
}
