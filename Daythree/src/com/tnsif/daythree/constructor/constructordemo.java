package com.tnsif.daythree.constructor;

import java.util.Scanner;
public class constructordemo {
	
	public static void main (String []args) {
	Scanner sc=new Scanner (System.in);
	
	String name,city;
	
	int id;
	System.out.println("enter Customer id");
	
	id=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter cutomer name");
	name=sc.nextLine();
	System.out.println("enter the customer city");
			city=sc.nextLine();
			System.out.println("");
			
			Customer c1=new Customer();
			c1.setCustomerCity(city);
			c1.setCustomerId(id);
			c1.setCustomerName(name);
			System.out.println(c1);
			
			Customer c2=new Customer(name,id,city);
			System.out.println(c2.getCustomerCity());
			System.out.println(c2.getCustomerId());
			System.out.println(c2.getCustomerName());
			
			System.out.println("");
			Customer c21=new Customer("SURU",87,"pune");
		System.out.println(c21);
	}
	}
