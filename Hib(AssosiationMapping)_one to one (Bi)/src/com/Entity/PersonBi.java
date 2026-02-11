package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PersonBi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Person_Id")
	private int pId;

	@Column(name = "Person_Name")
	private String pName;

	@Column(name = "Person_Address")
	private String pAddress;

	@OneToOne(cascade = CascadeType.ALL)
	private AdhharBi ad;

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

	public AdhharBi getAd() {
		return ad;
	}

	public void setAd(AdhharBi ad) {
		this.ad = ad;
	}

	@Override
	public String toString() {
		return "PersonBi [pId=" + pId + ", pName=" + pName + ", pAddress=" + pAddress + ", ad=" + ad + "]";
	}

}
