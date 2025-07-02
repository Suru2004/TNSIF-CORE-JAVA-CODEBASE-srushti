package com.tnsif.daytwo.loopsdemo;

public class nestedfofloop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //compulsory star pattern question is asked on nested loop
		
		//program to print the multiplication of table
		int beg=8;
		int end=20;
		
		for (int i=beg;i<=end;i++)
		{
			for(int j=1;j<=10;j++)
			{
				System.out.println(i+"*"+ j+"="+ i*j);
			}
			
		}
	}

}
