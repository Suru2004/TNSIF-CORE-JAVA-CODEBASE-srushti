package com.tnsif.finallyblock;
import java.util.Scanner;
public class Usingthrow {
	public static int acceptnumber()
	{   int per ;
           System.out.println("entr yiur percentage");
           per=acceptnumber();
           try {
        	   if(per<0)
        	 
          throw new negativeException() ;
        	   else if(per>100)
        		   throw new geaterValueException();
        	   else System.out.println("valid percentage");
           }
           catch(negativeException e | greater Excception)
           System.out.println(""+e.getmessage);
;        		   
}
}