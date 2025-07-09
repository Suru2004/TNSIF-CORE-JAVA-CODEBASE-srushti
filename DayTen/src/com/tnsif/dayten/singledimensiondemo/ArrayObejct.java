package com.tnsif.dayten.singledimensiondemo;

public class ArrayObejct {
	public static void main(String[] args) {
        Student[] arr;
        arr = new Student[5];

        arr[0] = new Student(101, "Suru");
        arr[1] = new Student(102, "Adii");
        arr[2] = new Student(103, "Priya");
        arr[3] = new Student(104, "Om");
        arr[4] = new Student(105, "Tejas");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element at " + i + ": " +
                arr[i].getRollNo() + "\t" + arr[i].getName());
        }
    }
}
