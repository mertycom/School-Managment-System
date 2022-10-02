package com.entity;

import java.io.Serializable;

public class Name implements Serializable {

	private static final long serialVersionUID = -1024812218875971542L;

	private String name;
	private String midName;
	private String surName;

	public Name(String name, String midName, String surName) {
		super();
		this.name = name;
		this.midName = midName;
		this.surName = surName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	@Override
	public String toString() {
		if (midName == null) {
			return "[" + name + "," + surName + "]";
		}
		return "[" + name + "," + midName + "," + surName + "]";
	}

}
