package com.tnsif.OnlineShoopping.Services;
import java.util.ArrayList;
import java.util.List;

import com.tnsif.OnlineShoopping.entities.Product;
public class ProductService {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(int productId) {
        productList.removeIf(p -> p.getProductId() == productId);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(productList);
    }

    public Product getProductById(int productId) {
        return productList.stream()
                         .filter(p -> p.getProductId() == productId)
                         .findFirst()
                         .orElse(null);
    }
}