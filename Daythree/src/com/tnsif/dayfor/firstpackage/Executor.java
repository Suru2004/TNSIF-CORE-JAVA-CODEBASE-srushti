package com.tnsif.dayfor.firstpackage;

public class Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Base b1=new Base();
b1.methodDefault();
b1.methodProtected();
b1.methodPublic();
//b1.methodPrivate();
//in this if we change the value of any variable we can but after applying encapsulation we cant chaneg the values

b1.varDefault=11;
b1.methodDefault();
b1.varProtected=50;
b1.methodProtected();
	}

}
