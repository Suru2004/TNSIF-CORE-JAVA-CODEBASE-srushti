package com.tnsif.OnlineShoopping.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCart {
    private Map<Product, Integer> items = new HashMap<>();

    // Add item to cart
    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    // Remove item from cart
    public void removeItem(Product product) {
        items.remove(product);
    }

    // Get all items
    public Map<Product, Integer> getItems() {
        return new HashMap<>(items);
    }

    // Calculate total cost
    public double getTotalCost() {
        return items.entrySet().stream()
                   .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                   .sum();
    }

    // Clear cart
    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        return items.entrySet().stream()
                   .map(entry -> "Product: " + entry.getKey().getName() + 
                                 ", Quantity: " + entry.getValue() + 
                                 ", Cost: Rs." + (entry.getKey().getPrice() * entry.getValue()))
                   .collect(Collectors.joining("\n")) + 
               "\nTotal Cost: Rs." + getTotalCost();
    }
}