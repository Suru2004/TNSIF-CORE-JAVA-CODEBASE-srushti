package com.shopping.service;
import  com.shoppingapp.Model.*;
import java.util.*;
public class ProductService {
	 private List<Product> productList;

	    public ProductService(List<Product> productList) {
	        this.productList = productList;
	    }

	    public List<Product> getAllProducts() {
	        return productList;
	    }

	    public Product getProductById(int productId) {
	        for (Product product : productList) {
	            if (product.getProductId() == productId) {
	                return product;
	            }
	        }
	        return null;
	    }
	}

