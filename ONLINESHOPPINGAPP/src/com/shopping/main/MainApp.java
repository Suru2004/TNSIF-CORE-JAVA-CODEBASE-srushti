package com.shopping.main;
import  com.shoppingapp.Model.*;
import com.shopping.service.*;
import java.util.*;
public class MainApp {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AdminService adminService = new AdminService();
        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService(adminService.getProductList());
        orderService orderService = new orderService();

        // Seed 15 products
        seedInitialProducts(adminService);

        boolean exit = false;
        while (!exit) {
            System.out.println("""
                \n==== Main Menu ====
                1. Admin Menu
                2. Customer Menu
                3. Exit
                Choose an option:""");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> showAdminMenu(sc, adminService, orderService);
                case 2 -> showCustomerMenu(sc, customerService, adminService.getProductList(), orderService);
                case 3 -> {
                    exit = true;
                    System.out.println("Exiting application. Goodbye!");
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }

    private static void showAdminMenu(Scanner sc, AdminService adminService, orderService orderService) {
        boolean back = false;
        while (!back) {
            System.out.println("""
                \n---- Admin Menu ----
                1. Add Product
                2. Remove Product
                3. View Products
                4. Create Admin
                5. View Admins
                6. Update Order Status
                7. View Orders
                8. Return
                Choose an option:""");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int qty = sc.nextInt();

                    adminService.addProduct(new Product(id, name, price, qty));
                    System.out.println("✅ Product added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter Product ID to remove: ");
                    int id = sc.nextInt();
                    adminService.removeProduct(id);
                    System.out.println("🗑️ Product removed.");
                }
                case 3 -> adminService.viewProducts().forEach(System.out::println);
                case 4 -> {
                    System.out.print("Enter Admin ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Username: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    adminService.createAdmin(new Admin(id, uname, email));
                    System.out.println("✅ Admin created.");
                }
                case 5 -> adminService.viewAdmins().forEach(System.out::println);
                case 6 -> {
                    System.out.print("Enter Order ID: ");
                    int oid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Status (Completed/Delivered/Cancelled): ");
                    String status = sc.nextLine();

                    adminService.updateOrderStatus(oid, status);
                    System.out.println("📦 Order status updated.");
                }
                case 7 -> adminService.viewOrders().forEach(System.out::println);
                case 8 -> back = true;
                default -> System.out.println("❌ Invalid admin option.");
            }
        }
    }

    private static void showCustomerMenu(Scanner sc, CustomerService customerService, List<Product> productList, orderService orderService) {
        boolean back = false;
        while (!back) {
            System.out.println("""
                \n---- Customer Menu ----
                1. Create Customer
                2. View Customers
                3. Place Order
                4. View Orders
                5. View Products
                6. Return
                Choose an option:""");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Customer ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    customerService.createCustomer(new Customer(id, name, email, address));
                    System.out.println("✅ Customer created.");
                }
                case 2 -> customerService.viewCustomers().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();
                    Customer cust = customerService.findCustomerById(cid);

                    if (cust == null) {
                        System.out.println("❌ Customer not found.");
                        break;
                    }

                    Map<Product, Integer> items = new HashMap<>();
                    while (true) {
                        System.out.print("Enter Product ID (-1 to stop): ");
                        int pid = sc.nextInt();
                        if (pid == -1) break;

                        Product p = productList.stream().filter(prod -> prod.getProductId() == pid).findFirst().orElse(null);
                        if (p == null) {
                            System.out.println("⚠️ Product not found.");
                            continue;
                        }

                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        if (qty <= p.getStockQuantity()) {
                            items.put(p, qty);
                        } else {
                            System.out.println("⚠️ Insufficient stock.");
                        }
                    }

                    customerService.placeOrder(cust, items, orderService.getOrders());
                    System.out.println("🛒 Order placed!");
                }
                case 4 -> {
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();
                    customerService.viewOrdersByCustomer(cid, orderService.getOrders()).forEach(System.out::println);
                }
                case 5 -> productList.forEach(System.out::println);
                case 6 -> back = true;
                default -> System.out.println("❌ Invalid option.");
            }
        }
    }

    private static void seedInitialProducts(AdminService adminService) {
        adminService.addProduct(new Product(101, "T-Shirt", 560, 100));
        adminService.addProduct(new Product(102, "Trouser", 1400, 50));
        adminService.addProduct(new Product(103, "Sneakers", 2500, 30));
        adminService.addProduct(new Product(104, "Jacket", 3200, 20));
        adminService.addProduct(new Product(105, "Cap", 150, 80));
        adminService.addProduct(new Product(106, "Belt", 350, 60));
        adminService.addProduct(new Product(107, "Shirt", 900, 70));
        adminService.addProduct(new Product(108, "Watch", 2700, 25));
        adminService.addProduct(new Product(109, "Backpack", 1800, 40));
        adminService.addProduct(new Product(110, "Socks", 100, 200));
        adminService.addProduct(new Product(111, "Laptop", 50000, 10));
        adminService.addProduct(new Product(112, "Phone", 25000, 15));
        adminService.addProduct(new Product(113, "Charger", 900, 100));
        adminService.addProduct(new Product(114, "Jeans", 1600, 45));
        adminService.addProduct(new Product(115, "Kurti", 1300, 35));
    }
}