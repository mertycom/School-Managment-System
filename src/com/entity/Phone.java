package com.entity;

import java.io.Serializable;

public class Phone implements Serializable{
	private static final long serialVersionUID = -3445792499368947302L;
	private double mobilePhone;
	private double homePhone;
	private double parentPhone;
	
	public Phone(double mobilePhone, double homePhone) {
		super();
		this.mobilePhone = mobilePhone;
		this.homePhone = homePhone;
	}
	public Phone(double mobilePhone, double homePhone, double parentPhone) {
		super();
		this.mobilePhone = mobilePhone;
		this.homePhone = homePhone;
		this.parentPhone = parentPhone;
	}
	public double getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(double mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public double getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(double homePhone) {
		this.homePhone = homePhone;
	}
	public double getParentPhone() {
		return parentPhone;
	}
	public void setParentPhone(double parentPhone) {
		this.parentPhone = parentPhone;
	}
	@Override
	public String toString() {
		if(parentPhone == 0) {
			return "Phone [mobile=" + mobilePhone + ", home=" + homePhone + "]";
		}
		return "Phone [mobile=" + mobilePhone + ", home=" + homePhone + ", parent=" + parentPhone + "]";
	}
	
}
