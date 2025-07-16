package com.tnsif.OnlineShoopping.Services;
import java.util.ArrayList;
import java.util.List;



import com.tnsif.OnlineShoopping.entities.Order;
import com.tnsif.OnlineShoopping.entities.Product;
import com.tnsif.OnlineShoopping.entities.ProductQuantityPair;
import java.util.List;
public class OrderService {
    private List<Order> orderList = new ArrayList<>();

    public void placeOrder(Order order) {
        // Update stock quantities
        for (ProductQuantityPair pair : order.getProducts()) {
            Product product = pair.getProduct();
            product.setStockQuantity(product.getStockQuantity() - pair.getQuantity());
        }
        order.getCustomer().addOrder(order);
        orderList.add(order);
    }

    public void updateOrderStatus(int orderId, String status) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setStatus(status);
        }
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orderList);
    }

    public Order getOrderById(int orderId) {
        return orderList.stream()
                       .filter(o -> o.getOrderId() == orderId)
                       .findFirst()
                       .orElse(null);
    }
}
