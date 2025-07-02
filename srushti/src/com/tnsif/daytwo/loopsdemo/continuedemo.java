package com.tnsif.daytwo.loopsdemo;

public class continuedemo {

	public static void main(String[] args) {
		for(int k=5;k<50;k++)
		{
			if(k%2 !=0)
				continue;
			
			System.out.println(k+"|");
		}
	}

}
