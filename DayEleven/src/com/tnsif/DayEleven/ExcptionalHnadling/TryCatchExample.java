package com.tnsif.DayEleven.ExcptionalHnadling;

public class TryCatchExample {
static void performDivision(int x,int y)
{
	System.out.println("im in mathod block");
	try 
	{
		
		System.out.println("im in try block");
		int z=x/y;
		System.out.println("result"+z);
	}
	System.out.println("im in try block");
}
catch (ArithmeticException e)
{
	Sytem.err.println("im in block"+e.getmessage);
}
}
