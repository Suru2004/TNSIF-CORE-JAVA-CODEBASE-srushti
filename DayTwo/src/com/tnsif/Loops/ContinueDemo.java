package com.tnsif.Loops;

public class ContinueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int k = 5; k < 50; k++) {
			if (k % 2 != 0)
				continue;

			System.out.println(k + "|");
		}
	}

}
