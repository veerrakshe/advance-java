package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@Column(name = "Person_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;

	@Column(name = "Person_Name")
	private String pName;

	@Column(name = "Person_Address")
	private String pAddress;

	@OneToOne(cascade = CascadeType.ALL)
	private Adhhar ad;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	public Adhhar getAd() {
		return ad;
	}

	public void setAd(Adhhar ad) {
		this.ad = ad;
	}

	@Override
	public String toString() {
		return "Person [pId=" + pId + ", pName=" + pName + ", pAddress=" + pAddress + ", ad=" + ad + "]";
	}

}
