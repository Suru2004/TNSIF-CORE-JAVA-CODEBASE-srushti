package com.tnsif.dayrhree.Encapsulation;

public class Oppsdemo {
    private int serialnumber;
    private String name;
    private int age;
    
    
    //getter setter
	public int getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(int serialnumber) {
		this.serialnumber = serialnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Oppsdemo [serialnumber=" + serialnumber + ", name=" + name + ", age=" + age + "]";
	}
}
