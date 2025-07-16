package com.shopping.service;
import  com.shoppingapp.Model.*;
import java.util.*;
public class orderService {
	 private List<Order> orders = new ArrayList<>();

	    public void addOrder(Order order) {
	        orders.add(order);
	    }

	    public Order getOrderById(int id) {
	        for (Order order : orders) {
	            if (order.getOrderId() == id) {
	                return order;
	            }
	        }
	        return null;
	    }

	    public List<Order> getOrders() {
	        return orders;
	    }
	}