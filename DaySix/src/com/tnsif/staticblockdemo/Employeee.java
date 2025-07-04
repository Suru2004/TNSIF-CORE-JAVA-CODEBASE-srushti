package com.tnsif.staticblockdemo;

public class Employeee {
 private String name;
 private int id;
 
 
 static String companyname="TNSIF";


public Employeee(String name, int id) {
	super();
	this.name = name;
	this.id = id;
}


@Override
public String toString() {
	return "Employeee [name=" + name + ", id=" + id + ",companyname="+companyname+"]";
}
 
 
}
