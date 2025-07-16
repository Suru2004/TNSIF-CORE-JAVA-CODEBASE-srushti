package com.shopping.service;
import  com.shoppingapp.Model.*;
import java.util.*;
public class CustomerService {
	private List<Customer> customerList = new ArrayList<>();

    public void createCustomer(Customer customer) {
        customerList.add(customer);
    }

    public List<Customer> viewCustomers() {
        return customerList;
    }

    public Customer findCustomerById(int customerId) {
        for (Customer customer : customerList) {
            if (customer.getUserId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public void placeOrder(Customer customer, Map<Product, Integer> items, List<Order> globalOrderList) {
        if (items == null || items.isEmpty()) return;

        List<ProductQuantityPair> orderItems = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product.getStockQuantity() >= quantity) {
                product.reduceStock(quantity);
                orderItems.add(new ProductQuantityPair(product, quantity));
            }
        }

        if (!orderItems.isEmpty()) {
            Order order = new Order(customer, orderItems);
            customer.addOrder(order);
            globalOrderList.add(order);
        }

        customer.getShoppingCart().clearCart(); // Clear cart after placing order
    }

    public List<Order> viewOrdersByCustomer(int customerId, List<Order> orderList) {
        List<Order> result = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getCustomer().getUserId() == customerId) {
                result.add(order);
            }
        }
        return result;
    }
}
