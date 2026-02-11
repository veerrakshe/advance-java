package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdhharBi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Adhhar_Id")
	private int aId;

	@Column(name = "Adhhar_Number")
	private String aNumber;

	@OneToOne(cascade = CascadeType.ALL)
	private PersonBi p;

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

	public PersonBi getP() {
		return p;
	}

	public void setP(PersonBi p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "AdhharBi [aId=" + aId + ", aNumber=" + aNumber + ", p=" + p + "]";
	}

}
