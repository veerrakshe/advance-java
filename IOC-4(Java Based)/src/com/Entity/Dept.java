package com.Entity;

import org.springframework.stereotype.Component;

@Component
public class Dept {

	private int did;

	private String dName;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	@Override
	public String toString() {
		return "Dept [did=" + did + ", dName=" + dName + "]";
	}

}
