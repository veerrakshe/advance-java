package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cmpId;

	private String cmpName;

	private String cmpAddress;

	private String cmpType;

	private int cmpPincode;

	public int getCmpId() {
		return cmpId;
	}

	public void setCmpId(int cmpId) {
		this.cmpId = cmpId;
	}

	public String getCmpName() {
		return cmpName;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	public String getCmpAddress() {
		return cmpAddress;
	}

	public void setCmpAddress(String cmpAddress) {
		this.cmpAddress = cmpAddress;
	}

	public String getCmpType() {
		return cmpType;
	}

	public void setCmpType(String cmpType) {
		this.cmpType = cmpType;
	}

	public int getCmpPincode() {
		return cmpPincode;
	}

	public void setCmpPincode(int cmpPincode) {
		this.cmpPincode = cmpPincode;
	}

	@Override
	public String toString() {
		return "Company [cmpId=" + cmpId + ", cmpName=" + cmpName + ", cmpAddress=" + cmpAddress + ", cmpType="
				+ cmpType + ", cmpPincode=" + cmpPincode + "]";
	}

}
