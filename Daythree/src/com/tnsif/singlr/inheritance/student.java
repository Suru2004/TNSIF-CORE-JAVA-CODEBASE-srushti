package com.tnsif.singlr.inheritance;

public class student extends Citizen {
  private String  studentname;
  private String address;
  private int rollNo;
  private String collegename;
  
  
  public student(String name, String adharno, String address, long phone) {
		
		
  }




public student(String name, String adharno, String address, long phone, String studentname, String address2, int rollNo,
		String collegename) {
	super(name, adharno, address, phone);
	this.studentname = studentname;
	address = address2;
	this.rollNo = rollNo;
	this.collegename = collegename;
}


public String getStudentname() {
	return studentname;
}


public void setStudentname(String studentname) {
	this.studentname = studentname;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public int getRollNo() {
	return rollNo;
}


public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}


public String getCollegename() {
	return collegename;
}


public void setCollegename(String collegename) {
	this.collegename = collegename;
}


@Override
public String toString() {
	return "student [studentname=" + studentname + ", address=" + address + ", rollNo=" + rollNo + ", collegename="
			+ collegename + ", getName()=" + getName() + ", getAdharno()=" + getAdharno() + ", getPhone()=" + getPhone()
			+ ", getClass()=" + getClass() + "]";
}



  
}

