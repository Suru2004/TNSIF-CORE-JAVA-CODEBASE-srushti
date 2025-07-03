package com.tnsif.dayfor.firstpackage;

public class Base {
int varDefault=10;
public int varPublic=20;
private int varPrivate=30;
protected int varProtected=40;


// DEFAULT 
void methodDefault()

{
	System.out.println("default access base classs");
	System.out.println("public variable:"+ varDefault);
	}
public void methodPublic()

{
	System.out.println("default access base classs");
	System.out.println("public variable:"+ varPublic);
	}
private void methodPrivate()

{
	System.out.println("default access base classs");
	System.out.println("public variable:"+ varPrivate);
	}
protected void methodProtected()

{
	System.out.println("default access base classs");
	System.out.println("public variable:"+ varProtected);
	}
}
