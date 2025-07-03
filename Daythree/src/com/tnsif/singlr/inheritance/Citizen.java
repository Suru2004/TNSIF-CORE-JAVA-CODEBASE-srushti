package com.tnsif.singlr.inheritance;

public class Citizen {

	private String name;
	private String adharno;
	private String address;
	private long phone;
	public Citizen(String name, String adharno, String address, long phone) {
		
		this.name = name;
		this.adharno = adharno;
		this.address = address;
		this.phone = phone;
	}
	public Citizen() {
		System.out.println("created");
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdharno() {
		return adharno;
	}
	public void setAdharno(String adharno) {
		this.adharno = adharno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
}
