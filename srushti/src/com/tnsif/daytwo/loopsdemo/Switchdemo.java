package com.tnsif.daytwo.loopsdemo;

public class Switchdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int userInput=2;
  switch(userInput)
  {
  case 1: System.out.println("current rechage details");
  break;
  case 2: System.out.println("current recharge expiry");
  break;
  case 3:System.out.println("talk to our customer support person");
  break;
  
  default: System.out.println(userInput+"it is not a valid input given by you");
  }
	}

}
