package com.tnsif.daythree.scanner;

public class person {
        //data memebers
	// getter method is used for getting the elements
	//setter
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getIncome() {
			return income;
		}
		public void setIncome(int income) {
			this.income = income;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getTax() {
			return tax;
		}
		public void setTax(int tax) {
			this.tax = tax;
		}
		public int mobileNumber() {
			return mobileNumber;
		}
		public void mobileNumber(int mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		private int income;
		private String gender;
		private int age;
		private int tax;
		private int mobileNumber;
		
}
		/*@Override
		public String toString() {
			return "person [name=" + name + ", income=" + income + ", gender=" + gender + ", age=" + age + ", tax="
					+ tax + "]";
		}
	}
*/


