package com.tnsif.staticblockdemo;

public class Myclass {
private static int Sector;
private int sector;
private static int srno;
static {
	System.out.println("------within block");
	srno=1000;
	Sector=1001;
	}

//default constructor
public Myclass() {
	super();
	Sector = sector;
	System.out.println("within default constructor");
	srno++;
	sector++;
}

@Override
public String toString() {
	return "Myclass [serialno="+srno+",Sector=" + Sector + "]";
}

static void display()

{
	//System.out.printf("section:"+sector);
	System.out.printf("srno:",+srno);
	}
}
