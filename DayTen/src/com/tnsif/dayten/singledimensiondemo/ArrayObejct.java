package com.tnsif.dayten.singledimensiondemo;

public class ArrayObejct {
public static void main(String [] args) {
Student[]array;
arr=new Student[5];
arr[0]=new Student (101,"Suru");
arr[1]=new Student(102,"Adii");
arr[2]=new Student(103,"priya");
arr[3]=new Student(103,"om");
arr[4]=new Student(103,"tejas");
for(int i=0; i<=arr.length; i++)
{
	System.out.println("Elementsat"+i+":"+arr[i]);
}
}
}