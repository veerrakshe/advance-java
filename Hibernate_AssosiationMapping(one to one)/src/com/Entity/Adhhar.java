package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adhhar {

	@Id
	@Column(name = "Adhhar_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aId;

	@Column(name = "Addhar_Number")
	private String aNumber;

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaNumber() {
		return aNumber;
	}

	public void setaNumber(String aNumber) {
		this.aNumber = aNumber;
	}

	@Override
	public String toString() {
		return "Adhhar [aId=" + aId + ", aNumber=" + aNumber + "]";
	}

}
