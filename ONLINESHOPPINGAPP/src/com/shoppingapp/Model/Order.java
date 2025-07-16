package com.shoppingapp.Model;
import java.util.*;
public class Order {
	 private static int nextOrderId = 1;
	    private int orderId;
	    private Customer customer;
	    private List<ProductQuantityPair> products;
	    private String status;

	    public Order(Customer customer, List<ProductQuantityPair> products) {
	        this.orderId = nextOrderId++;
	        this.customer = customer;
	        this.products = products;
	        this.status = "Pending";
	    }

	    public int getOrderId() { return orderId; }
	    public Customer getCustomer() { return customer; }
	    public List<ProductQuantityPair> getProducts() { return products; }
	    public String getStatus() { return status; }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder("Order ID: " + orderId + ", Customer: " + customer.getUsername() + ", Status: " + status + "\n");
	        for (ProductQuantityPair pq : products) {
	            sb.append(pq.toString()).append("\n");
	        }
	        return sb.toString();
	    }
	}
