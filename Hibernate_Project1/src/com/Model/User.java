package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@Column(name = "USER_ID")
	private int uId;
	@Column(name = "USER_NAME")
	private String uName;
	@Column(name = "USER_SALARY")
	private int uSalary;
	@Column(name = "USER_AGE")
	private int uAge;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public int getuSalary() {
		return uSalary;
	}

	public void setuSalary(int uSalary) {
		this.uSalary = uSalary;
	}

	public int getuAge() {
		return uAge;
	}

	public void setuAge(int uAge) {
		this.uAge = uAge;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uSalary=" + uSalary + ", uAge=" + uAge + "]";
	}

}
