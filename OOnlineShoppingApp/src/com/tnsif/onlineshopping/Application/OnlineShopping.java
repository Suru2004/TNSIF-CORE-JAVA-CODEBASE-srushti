package com.tnsif.onlineshopping.Application;

import java.util.Map;
import java.util.Scanner;

import com.tnsif.OnlineShoopping.Services.AdminService;
import com.tnsif.OnlineShoopping.Services.CustomerService;
import com.tnsif.OnlineShoopping.Services.OrderService;
import com.tnsif.OnlineShoopping.Services.ProductService;
import com.tnsif.OnlineShoopping.entities.Admin;
import com.tnsif.OnlineShoopping.entities.Customer;
import com.tnsif.OnlineShoopping.entities.Order;
import com.tnsif.OnlineShoopping.entities.Product;
import com.tnsif.OnlineShoopping.entities.ShoppingCart;

public class OnlineShopping {
    private static ProductService productService = new ProductService();
    private static CustomerService customerService = new CustomerService();
    private static OrderService orderService = new OrderService();
    private static AdminService adminService = new AdminService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Admin Menu\n2. Customer Menu\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void adminMenu() {
        int adminChoice;
        do {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Products");
            System.out.println("4. Create Admin");
            System.out.println("5. View Admins");
            System.out.println("6. Update Order Status");
            System.out.println("7. View Orders");
            System.out.println("8. Return");
            System.out.print("Choose an option: ");
            adminChoice = scanner.nextInt();
            
            switch (adminChoice) {
                case 1: addProduct(); break;
                case 2: removeProduct(); break;
                case 3: viewProducts(); break;
                case 4: createAdmin(); break;
                case 5: viewAdmins(); break;
                case 6: updateOrderStatus(); break;
                case 7: viewOrders(); break;
                case 8: 
                    System.out.println("Exiting Admin Menu...");
                    break;
                default: 
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (adminChoice != 8);
    }

    private static void customerMenu() {
        int customerChoice;
        do {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Create Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Add to Cart");       
            System.out.println("4. View Cart");   
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. View Products");
            System.out.println("8. Return");
            System.out.print("Choose an option: ");
            customerChoice = scanner.nextInt();
            
            switch (customerChoice) {
                case 1: createCustomer(); break;
                case 2: viewCustomers(); break;
                case 3: addToCart(); break;       
                case 4: viewCart(); break;
                case 5: placeOrder(); break;
                case 6: viewCustomerOrders(); break;
                case 7: viewProducts(); break;
                case 8: 
                    System.out.println("Exiting Customer Menu...");
                    break;
                default: 
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (customerChoice != 6);
    }

    private static void addToCart() {
		// TODO Auto-generated method stub
    	System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerService.getCustomer(customerId);
        
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        
        viewProducts();  // Show available products
        
        System.out.print("Enter Product ID to add to cart: ");
        int productId = scanner.nextInt();
        Product product = productService.getProductById(productId);
        
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }
        
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        
        // Check stock availability
        if (product.getStockQuantity() < quantity) {
            System.out.println("Insufficient stock! Available: " + product.getStockQuantity());
            return;
        }
        
        customer.getShoppingCart().addItem(product, quantity);
        System.out.println("Product added to cart successfully!");
    
	}

	private static void viewCart() {
		// TODO Auto-generated method stub
		 System.out.print("Enter Customer ID: ");
		    int customerId = scanner.nextInt();
		    Customer customer = customerService.getCustomer(customerId);
		    
		    if (customer == null) {
		        System.out.println("Customer not found!");
		        return;
		    }
		    
		    ShoppingCart cart = customer.getShoppingCart();
		    if (cart.getItems().isEmpty()) {
		        System.out.println("Cart is empty!");
		        return;
		    }
		    
		    System.out.println("Cart Contents:");
		    System.out.println(cart);
	}

	// Admin operations
    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Stock Quantity: ");
        int stockQuantity = scanner.nextInt();
        
        productService.addProduct(new Product(productId, name, price, stockQuantity));
        System.out.println("Product added successfully!");
    }

    private static void removeProduct() {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        productService.removeProduct(productId);
        System.out.println("Product removed successfully!");
    }

    private static void viewProducts() {
        System.out.println("Products:");
        productService.getProducts().forEach(System.out::println);
    }

    private static void createAdmin() {
        System.out.print("Enter Admin ID: ");
        int adminId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        adminService.addAdmin(new Admin(adminId, username, email));
        System.out.println("Admin created successfully!");
    }

    private static void viewAdmins() {
        System.out.println("Admins:");
        adminService.getAdmins().forEach(System.out::println);
    }

    private static void updateOrderStatus() {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new status (Completed/Delivered/Cancelled): ");
        String status = scanner.nextLine();
        
        orderService.updateOrderStatus(orderId, status);
        System.out.println("Order status updated successfully!");
    }

    private static void viewOrders() {
        System.out.println("Orders:");
        orderService.getOrders().forEach(System.out::println);
    }

    // Customer operations
    private static void createCustomer() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        
        customerService.addCustomer(new Customer(userId, username, email, address));
        System.out.println("Customer created successfully!");
    }

    private static void viewCustomers() {
        System.out.println("Customers:");
        customerService.getCustomers().forEach(System.out::println);
    }

    private static void placeOrder() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerService.getCustomer(customerId);
        
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        
        ShoppingCart cart = customer.getShoppingCart();
        Map<Product, Integer> items = cart.getItems();
        
        if (items.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        
        // Check stock availability
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product.getStockQuantity() < quantity) {
                System.out.println("Insufficient stock for product: " + product.getName());
                return;
            }
        }
        
        orderService.placeOrder(new Order(customer, items));
        cart.clear();
        System.out.println("Order placed successfully!");
    }

    private static void viewCustomerOrders() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerService.getCustomer(customerId);
        
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        
        System.out.println("Orders for " + customer.getUsername() + ":");
        customer.getOrders().forEach(System.out::println);
    }
}
