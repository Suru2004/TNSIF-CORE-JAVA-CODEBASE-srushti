package com.tnsif.daythree.constructor;

public class Customer {
   private String customerName;
   private int customerId;
   private String customerCity;
   
   
   //default constrcutor 
   public Customer()
   
   {
	   System.out.println("hello this is deafult ");
   }


public Customer(String customerName, int customerId, String customerCity) {
	this();// calling defualt constructor 
	System.out.println("hello this is para constructor");
	this.setCustomerName(customerName);
	this.setCustomerId(customerId);
	this.setCustomerCity(customerCity);
}


public String getCustomerName() {
	return customerName;
}


public void setCustomerName(String customerName) {
	this.customerName = customerName;
}


public int getCustomerId() {
	return customerId;
}


public void setCustomerId(int customerId) {
	this.customerId = customerId;
}


public String getCustomerCity() {
	return customerCity;
}


public void setCustomerCity(String customerCity) {
	this.customerCity = customerCity;
}



/*@Override
public String toString() {
	return "Customer [customerName=" + customerName + ", customerId=" + customerId + ", customerCity=" + customerCity
			+ "]";
}
}

*/
}



