package com.tnsif.dayseven.overriding;

public class Overridingdemo {
public static void main(String[] args) {
		
		RBI rbi;
		
		//Dynamic binding assigning child object to parent class reference variable 
		rbi=new SBI();
		System.out.println(rbi.getRateofInterest());
		
		rbi=new ICIC();
		System.out.println(rbi.getRateofInterest());
		
		rbi=new HDFC();
		System.out.println(rbi.getRateofInterest());

	}

}