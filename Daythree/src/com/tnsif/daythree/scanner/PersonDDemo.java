package com.tnsif.daythree.scanner;

import java.util.Scanner;

public class PersonDDemo {

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner ob = new Scanner(System.in)) {
			String name;
			 System.out.println("Enter person name::");
			 name=ob.next();
			 System.out.println("Enter age:");
			 int age= ob.nextInt();
			 System.out.println("enter gender");
			 String gender = ob.next();
			 
			 System.out.println("Enter mobile number");
			 System.out.println("enter income");
			 int income=ob.nextInt();
			 
			 // person object and initialization values ussing setter
			 person person=new person();
			 person.setName(name);
			 person.setAge(age);
			 person.setGender(gender);
			 person.setIncome(income);
			 person.mobileNumber();
			 
			 System.out.println(person.getName());
			 System.out.println(person.getAge());
			 System.out.println(person.getGender());
			 System.out.println(person.mobileNumber());
			 
			 System.out.println(person);
		}
	}
         
}

