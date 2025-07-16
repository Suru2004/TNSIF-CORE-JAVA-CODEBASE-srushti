package com.shopping.service;

import  com.shoppingapp.Model.*;
import java.util.*;


public class AdminService {
	
	    private List<Product> productList = new ArrayList<>();
	    private List<Admin> adminList = new ArrayList<>();
	    private List<Order> orderList = new ArrayList<>();

	    public void addProduct(Product product) {
	        productList.add(product);
	    }

	    public void removeProduct(int productId) {
	        productList.removeIf(p -> p.getProductId() == productId);
	    }

	    public List<Product> viewProducts() {
	        return productList;
	    }

	    public void createAdmin(Admin admin) {
	        adminList.add(admin);
	    }

	    public List<Admin> viewAdmins() {
	        return adminList;
	    }

	    public void updateOrderStatus(int orderId, String status) {
	        for (Order order : orderList) {
	            if (order.getOrderId() == orderId) {
	                order.setStatus(status);
	                return;
	            }
	        }
	    }

	    public List<Order> viewOrders() {
	        return orderList;
	    }

	    public List<Product> getProductList() {
	        return productList;
	    }

	    public List<Order> getOrderList() {
	        return orderList;
	    }

	    public void addOrder(Order order) {
	        orderList.add(order);
	    }
	}



