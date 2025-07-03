package com.tnsif.association.hasa;

public class person {
private String name;
private Address address;
public person(String name, Address address) {
	super();
	this.name = name;
	this.address = address;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}


///method to display person  info

public void displayInfo()

{
	System.out.println("Name:"+name);
	System.out.println("Address:"+address.getstreet()+","+address.getcity()+",");
	
	}
}
