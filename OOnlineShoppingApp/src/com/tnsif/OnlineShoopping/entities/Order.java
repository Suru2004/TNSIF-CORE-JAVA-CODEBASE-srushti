package com.tnsif.OnlineShoopping.entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Order {
	  private static int orderCounter = 1;
	    private int orderId;
	    private Customer customer;
	    private List<ProductQuantityPair> products;
	    private String status = "Pending";

	    public Order(Customer customer, Map<Product, Integer> items) {
	        this.orderId = orderCounter++;
	        this.customer = customer;
	        this.products = new ArrayList<>();
	        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
	            products.add(new ProductQuantityPair(entry.getKey(), entry.getValue()));
	        }
	    }

	    // Getters and Setters
	    public int getOrderId() { return orderId; }
	    public Customer getCustomer() { return customer; }
	    public List<ProductQuantityPair> getProducts() { return products; }
	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }

	    @Override
	    public String toString() {
	        return "Order ID: " + orderId + ", Customer: " + customer.getUsername() + 
	               ", Status: " + status + "\n" +
	               products.stream()
	                       .map(ProductQuantityPair::toString)
	                       .collect(Collectors.joining("\n"));
	    }
	}